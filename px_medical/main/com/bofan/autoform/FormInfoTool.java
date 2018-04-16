package com.bofan.autoform;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.ValidScope;
import org.apache.velocity.tools.view.ViewContext;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.dictionary.support.DictionarysInVelocityToolbox;

@DefaultKey("FormInfo")
@ValidScope(Scope.REQUEST)
public class FormInfoTool {
	protected Context context;
    
	public void init(Object context) {
		ViewContext ctx = (ViewContext)context;
        this.context = ctx.getVelocityContext();
    }
	
	private static Object getProperty(Object bean, String fieldName) {
		if (bean instanceof Map) {
			return ((Map<?,?>)bean).get(fieldName);
		} else {
			try {
				return PropertyUtils.getProperty(bean, fieldName);
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	public FormWrap wrap(Object info, Map<String,Object> setting) {
		return new FormWrap(info, setting);
	}

	public class FormWrap {
		private Object info;
		private Object data;
		private String name;
		private String layout;
		private String action;
		private List<String> scenes;
		private String method = "GET";
		private FormFieldWrap[] fields;
		private Map<String,Object> setting;
		
		@SuppressWarnings("unchecked")
		public FormWrap(Object info, Map<String,Object> setting) {
			this.info = info;
			this.setting = setting;
			FormInfo formInfo = info.getClass().getAnnotation(FormInfo.class);
			if (formInfo != null) {
				this.name = formInfo.name();
				this.layout = formInfo.layout();
				this.action = formInfo.action();
				this.method = formInfo.method().name();
			}
			if (setting != null) {
				this.name = (String)option("name", this.name);
				this.layout = (String)option("layout", this.layout);
				this.action = (String)option("action", this.action);
				this.method = (String)option("method", this.method);
				this.scenes = (List<String>)option("scenes", null);
				this.data = option("data", null);
			}
			initFormFields();
			
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getMethod() {
			return this.method;
		}
		
		public String getLayout() {
			return this.layout;
		}
		
		public String getAction() {
			return this.action;
		}

		public List<String> getScenes() {
			return scenes;
		}
		
		public Object option(String name, Object defaultValue) {
			Object value = null;
			if (this.setting != null) {
				value = this.setting.get(name);
			}
			return (value == null) ? defaultValue : value;
		}
		
		public boolean sceneEnabled(String scene) {
			if (this.scenes == null) return true;
			if (scene.isEmpty()) return true;
			return this.scenes.contains(scene);
		}
		
		public boolean isDefaultScene(String scene) {
			if (scene.isEmpty()) return true;
			if (this.scenes == null) return false;
			return this.scenes.contains(scene);
		}
		
		public boolean sceneVisible(String scene) {
			if (!sceneEnabled(scene)) return false;
			// TODO: 根据场景开关字段的值决定场景是否显示
			return true;
		}
		
		public FormFieldWrap[] getFields() {
			return this.fields;
		}

		@SuppressWarnings("unchecked")
		private void initFormFields() {
			ArrayList<FormFieldWrap> formFields = new ArrayList<FormFieldWrap>();
			Class<?> clazz = info.getClass();
			Map<?,?> fieldsSetting = (Map<?,?>)this.option("fields", null);
			
			while (clazz != Object.class && clazz != BaseCommandInfo.class) {
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					FormField ff = field.getAnnotation(FormField.class);
					if (ff == null) continue;
					if (this.sceneEnabled(ff.scene())) {
						Map<String,Object> options = null;
						if (fieldsSetting != null) {
							options = (Map<String,Object>)fieldsSetting.get(field.getName());
						}
						formFields.add(new FormFieldWrap(this, field, ff, options));
					}
				}
				clazz = clazz.getSuperclass();
			}
			this.fields = new FormFieldWrap[formFields.size()];
			formFields.toArray(this.fields);
		}
	}
	
	public class FormFieldWrap {
		private FormField formField;
		private Field field;
		private String mode;
		private FormWrap wrap;
		private Map<String, Object> options;
		private Object value;
		private String valueString;
		private String validatorAttrs;
		private boolean required;
		
		private FormFieldWrap(FormWrap wrap, Field field, FormField formField, Map<String, Object> fieldOptions) {
			this.wrap = wrap;
			this.field = field;
			this.formField = formField;
			initValue();
			initOptions(fieldOptions);
			initValidator();
		}
		
		private Object getBindValue(Object data, String locate) {
			Object value = null;
			if (data instanceof List) {
				List<?> list = (List<?>)data;
				for (Object d : list) {
					value = getBindValue(d, locate);
					if (value != null) break;
				}
			} else {
				String[] s = locate.split("\\.");
				value = data;
				for (int i = 0; value != null && i < s.length; i++) {
					value = getProperty(value, s[i]);
				}
			}
			return value;
		}
		
		private void initValue() {
			// initialize value
			if (this.wrap.data != null) {
				String dataBind = this.formField.dataBind();
				if (dataBind.isEmpty()) {
					dataBind = this.field.getName();
				}
				this.value = getBindValue(this.wrap.data, dataBind);
			}
			if (this.value == null) {
				this.value = getProperty(this.wrap.info, this.field.getName());
			}
			// format the value to string
			if (this.value == null) {
				this.valueString = "";
			} else if (this.value.getClass().isArray()) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < Array.getLength(this.value); i++) {
					Object item = Array.get(this.value, i);
					if (item != null) {
						if (i > 0) {
							sb.append(',');
						}
						sb.append(item.toString());
					}
				}
				this.valueString = sb.toString();
			} else if (this.value instanceof Collection) {
				StringBuffer sb = new StringBuffer();
				for (Object v : (Collection<?>)this.value) {
					if (v != null) {
						if (sb.length() > 0) {
							sb.append(',');
						}
						sb.append(v.toString());
					}
				}
				this.valueString = sb.toString();
			} else {
				this.valueString = this.value.toString();
			}
		}
		
		private void initOptions(Map<String, Object> fieldOptions) {
			// initialize the options
			this.options = new HashMap<String, Object>();
			for (String option : this.formField.options()) {
				int p = option.indexOf('=');
				if (p < 0) throw new RuntimeException("option must has = ");
				String name = option.substring(0, p).trim();
				String v = option.substring(p+1).trim();
				Object value = v;
				if (v.charAt(0) == '$') {
					value = this.getBindValue(wrap.data, v.substring(1));
					if (value == null) {
						value = getProperty(wrap.info, v.substring(1));
					}
				} else if (v.charAt(0) == '#') {
					value = DictionarysInVelocityToolbox.getDictionary(v.substring(1));
				} else if (v.charAt(0) == '@') {
					value = this.getContextValue(v.substring(1));
				}
				this.options.put(name, value);
			}
			if (fieldOptions != null) {
				this.options.putAll(fieldOptions);
			}
			this.mode = (String)this.options.get("mode");
			if (this.mode == null || this.mode.isEmpty()) {
				this.mode = (String)wrap.option("mode", "field");
			}
		}

		public FormWrap getInfo() {
			return this.wrap;
		}
		
		public String getName() {
			return this.field.getName();
		}

		public String getType() {
			return this.formField.type();
		}
		
		public String getLabel() {
			return this.formField.label();
		}
		
		public String getScript() {
            return this.formField.script();
        }
		
		public String getDataBind() {
			return this.formField.dataBind();
		}
		
		public String getMode() {
			return this.mode;
		}
		
		public String getScene() {
			return this.formField.scene();
		}
		
		private Object getContextValue(String locate) {
			String[] s = locate.split("\\.");
			Object value = context.get(s[0]);
			for (int i = 1; value != null && i < s.length; i++) {
				value = getProperty(value, s[i]);
			}
			return value;
		}
		
		public Object getValue() {
			return this.value;
		}
		
		public Object valueOf(String fieldName) {
			return getProperty(wrap.info, fieldName);
		}
		
		public Object getValueString() {
			return this.valueString;
		}

		public Map<String, Object> getOptions() {
			return this.options;
		}
		
		public Object option(String name) {
			return this.options.get(name);
		}
		
		public Object option(String name, Object defaultValue) {
			Object value = this.options.get(name);
			if(value == null) value = defaultValue;
			return value;
		}
		
		public Validator[] getValidator() {
			return this.formField.validator();
		}
		
		public String getValidatorAttrs() {
			return this.validatorAttrs;
		}
		
		private void initValidator() {
			StringBuffer sb = new StringBuffer();
			for (Validator v : this.formField.validator()) {
				if ( ! wrap.sceneEnabled(v.scene())) continue;
				if (v.required()) {
					this.required = wrap.isDefaultScene(v.scene());
					sb.append("required");
					if (!v.scene().isEmpty()) {
						sb.append('-').append(v.scene());
					}
					sb.append("=\"required\" ");
				}
				if ( ! v.value().isEmpty()) {
					sb.append("validator");
					if (!v.scene().isEmpty()) {
						sb.append('-').append(v.scene());
					}
					sb.append("=\"").append(v.value()).append("\" ");
				}
			}
			this.validatorAttrs = sb.toString();
		}
		
		public boolean getRequired() {
			return this.required;
		}
	}
	
}
