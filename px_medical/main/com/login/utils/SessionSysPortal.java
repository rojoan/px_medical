/*
 * <p> Title:  AppProperties.java</p>
 * <p>Copyright:   bofan 2013</p>
 * <p>Company: 博繁科技 </p>
 */
package com.login.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.ValidScope;
import org.apache.velocity.tools.generic.ContextTool;
import org.apache.velocity.tools.generic.ValueParser;
import org.apache.velocity.tools.view.ViewContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.bofan.basesystem.common.Constants;
import com.bofan.manage.valueobject.SysOrg;
import com.bofan.manage.valueobject.SysPortal;
import com.bofan.manage.valueobject.SysUserInfo;
import com.manage.service.UserOrgService;

/**
 * <p> Calss Name: UserOrgProperties.java </p>
 * @version 1.0
 * @author wmg
 * @created 2017-12-29
 */
@Component
@DefaultKey("SessionSysPortal")
@ValidScope(Scope.SESSION)
public class SessionSysPortal extends ContextTool implements Serializable {
    /** Default serialVersionUID */
    private static final long serialVersionUID = 1L;
    private Map<Long, SysPortal> orgIdPortalMap = new HashMap<Long, SysPortal>();
    // @Autowired
    // private UserOrgService userOrgService;
    // (UserOrgService) BeanContainer.getBean(UserOrgService.class.getSimpleName());
    private String rootOrgCode;
    private SysPortal sysPortal;

    @Deprecated
    public void init(Object obj) {
        if (obj instanceof ViewContext) {
            ViewContext ctx = (ViewContext) obj;
            this.context = ctx.getVelocityContext();
            HttpServletRequest request = ctx.getRequest();
            SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);

            if (userInfo != null) {
                WebApplicationContext wac = (WebApplicationContext) request.getServletContext()
                        .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
                UserOrgService userOrgService = (UserOrgService) wac.getBean("userOrgService");

                SysOrg rootOrg = userOrgService.loadRootOrg(userInfo);
                // rootOrgCode = userInfo.getSysOrg().getCode().substring(0, 3);
                if (orgIdPortalMap.containsKey(rootOrg.getOrgId())) {
                    this.sysPortal = orgIdPortalMap.get(rootOrg.getOrgId());
                } else {
                    SysPortal portal = userOrgService.selectAObject(SysPortal.class, rootOrg.getOrgId());
                    if (portal == null) {
                        portal = userOrgService.selectAObject(SysPortal.class, new Long(0));
                    }
                    this.sysPortal = userOrgService.selectAObject(SysPortal.class, rootOrg.getOrgId());

                    orgIdPortalMap.put(rootOrg.getOrgId(), this.sysPortal);
                }
                ;
            }
        }
    }
    @Override
    protected void configure(ValueParser parser) {
        // do ContextTool config first
        super.configure(parser);

        HttpServletRequest request = (HttpServletRequest) parser.getValue(ViewContext.REQUEST);
        SysUserInfo userInfo = (SysUserInfo) request.getSession().getAttribute(Constants.USER_KEY);

        if (userInfo != null) {
            WebApplicationContext wac = (WebApplicationContext) request.getServletContext()
                    .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            UserOrgService userOrgService = (UserOrgService) wac.getBean("userOrgService");

            SysOrg rootOrg = userOrgService.loadRootOrg(userInfo);
            rootOrgCode = userInfo.getSysOrg().getCode().substring(0, 3);
            if (orgIdPortalMap.containsKey(rootOrg.getOrgId())) {
                this.sysPortal = orgIdPortalMap.get(rootOrg.getOrgId());
            } else {
                this.sysPortal = userOrgService.selectAObject(SysPortal.class, rootOrg.getOrgId());
                orgIdPortalMap.put(rootOrg.getOrgId(), this.sysPortal);
            }
            ;
        }
    }

    public String getRootOrgCode() {
        return rootOrgCode;
    }

    public void setRootOrgCode(String rootOrgCode) {
        this.rootOrgCode = rootOrgCode;
    }

    @SuppressWarnings("rawtypes")
    public String get(String sysPortalFieldName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        if (this.sysPortal == null) {
            this.sysPortal = new SysPortal();
            this.sysPortal.setAppTitle("城乡医疗一体化平台(sysportal未设置)");
            this.sysPortal.setAppLogo("/notsetlogo.png");
            this.sysPortal.setAppBackground("/defaultbackground.jpg");
        }
        Class sysPortalClass = this.sysPortal.getClass();
        // sysPortalClass.getDeclaredField(name)
        Field field = sysPortalClass.getDeclaredField(sysPortalFieldName);
        field.setAccessible(true);// 修改访问权限
        String returnValue = field.get(this.sysPortal).toString();
        return returnValue;
    }

    public SysPortal getSysPortal() {
        return sysPortal;
    }

}
