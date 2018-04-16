var common = {
	defaultIp: "127.0.0.1:8080",
	orgId: 'orgId_key',
	rowId: 'row_id_key',
	patientId: 'patientId_key',
	inspectionId: 'inspectionId_key',
	patientExamId: 'patientExamId_key',
	lisInspectionSampleId: 'lisInspectionSampleId_key',
	currentUserInfo: 'current_user_key',
	historyTab: [],
	dicDataMap: {},
	queryParams : {pageNumber: 0, pageSize: 10, total: 0},
	getServer: function () {
		var ip = window.localStorage.getItem("_serverIp");
		var port = window.localStorage.getItem("_serverPort");
		if (null != ip && ip != "" && ip != undefined && null != port && port != "" && port != undefined) {
			return "http://" + ip + ":" + port;
		} else {
			return "http://" + common.defaultIp;
		}
	},
	// 提示页面正在加载
	loading: function (){
		$('body').prepend('<div class="loadding-div"><img src="' + rootPath + '/mobile/style/images/loading.gif" /></div>');
	},
	// 关闭页面正在加载
	loaded: function () {
		$('.loadding-div').remove();
	},
	// 设置时分秒
	setCurTime: function (h_ele, m_ele, s_ele) {
		var nowTime = new Date();
		var hour = tody.getHours();
		var min = tody.getMinutes();
		var sec = tody.getSeconds();
		$(h_ele).val((hour.length == 1 ? "0" + hour : hour));
		$(m_ele).val((min.length == 1 ? "0" + min : min));
		$(s_ele).val((sec.length == 1 ? "0" + sec : sec));
	},
	// 将参数存放到内存中
	setCache: function (key, value){
		sessionStorage.setItem(key, value);
	},
	// 从内存中取出参数
	getCache: function (key){
		return sessionStorage.getItem(key);
	},
	// 设置本地缓存数据
	setLocalCache: function (key, value) {
		localStorage.setItem(key, value);
		//localStorage.getItem("key","value")
		//localStorage.removeItem("key")
		//localStorage.clear()
	},
	// 取出本地缓存数据
	getLocalCache: function (key) {
		return localStorage.getItem(key)
	},
	// 删除本地缓存所有数据
	removeAllLocal: function () {
		localStorage.clear();
	},
	// 删根据key除本地缓存的数据
	removeLocalCacheByKey: function (key) {
		localStorage.removeItem(key);
	},
	// 返回上一个页面
	goBack: function (refresh){
		if (refresh) {
			history.go(-1);
		} else {
			history.back();
		}
	},
	// 打开一个页新面
	openPage: function (url, oneKey, oneValue, twoKey, twoValue, thrKey, thrValue){
		if (oneKey != undefined && oneValue != undefined) {
			common.setCache(oneKey, oneValue);
		}
		if (twoKey != undefined && twoValue != undefined) {
			common.setCache(twoKey, twoValue);
		}
		if (thrKey != undefined && thrValue != undefined) {
			common.setCache(thrKey, thrValue);
		}
		window.location = url;
	},
	// 跳转到登录页面
	toLogin: function (value){
		if (loginPage == value) {
			common.openPage(rp + common.root + loginPage);
		}
	},
	// 计算百分比
	percent: function (num, total){
		return (Math.round(num / total * 10000) / 100.00);
	},
	// 获取URL中的参数
	getRequestParams: function(paramName) {
		var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	},
	replace: function (ori, target, source){
		if (null == source || "" == source || source == undefined){return "";}
		var reg = new RegExp(ori, "g");//g,表示全部替换。
		return source.replace(reg, target);
	},
	getSex: function (patientSex){
		if (patientSex == '1'){
			return "男";
		} else if (patientSex == '2'){
			return "女";
		} else {
			return "";
		}
	},
	auditStatus: function (status){
		var result = "";
		switch (status) {
			case 0:
				result = "暂存";
				break;
			case 1:
				result = "待审核";
				break;
			case 2:
				result = "待接诊";
				break;
			case 3:
				result = "待就诊";
				break;
			case 4:
				result = "已就诊";
				break;
			case 5:
				result = "已拒绝";
				break;
			default:
				break;
		}
		return result;
	},
	getPatientType: function (value) {
		var text = "";
		switch(value) {
			case "1":
				text = "住院";
			  break;
			case "2":
				text = "门诊";
			  break;
			case "3":
				text = "住院急诊";
			  break;
			case "4":
				text = "门诊急诊";
			  break;
			default:
				text = "未知";
		}
		return text;
	},
	getConsultStatus: function (value) {
		var status = "";
		switch(value) {
			case "0":
				status = "检查登记";
			  break;
			case "1":
				status = "已申请";
			  break;
			case "2":
				status = "诊断中";
			  break;
			case "3":
				status = "已完成";
			  break;
			default:
				status = "未知";
		}
		return status;
	},
	getInspectionState: function (inspectionState){
		if (inspectionState == "audited"){
			$('#inspectionState').val("已审核");
		} else if (inspectionState == "inspecting"){
			$('#inspectionState').val("正在检验");
		} else if (inspectionState == "reported"){
			$('#inspectionState').val("已报告");
		} else {
			return "";
		}
	},
	getConsultType: function (value) {
		var type = "";
		switch(value) {
			case "1":
				type = "非交互式";
			  break;
			case "2":
				type = "交互式";
			  break;
			default:
				type = "未知";
		}
		return type;
	},
	loadUnit: function (eleId){
		$.post(rootPath + '/sys/queryUnitFilterUserUnit.do', {},
			function(data){
				if (null == data || data.length == undefined || data.length <= 0) { return ; }
				var html = [];
				html.push('<option value="">&nbsp;</option>');
				$.each(data, function (){
					html.push('<option value="' + this.orgId + '" title="' + this.orgNo + '">' + this.name + '</option>');
				});
				$('#' + eleId).html(html.join(''));
		}, 'json');	
	},
	loadDep: function (unitId, eleId) {
		if (unitId == "") {return false;}
		$.post(rootPath + "/sys/queryDepByUnitId.do", {unitId:unitId},
			function(data){
				$('#' + eleId).html('');
				if (null == data || data.length == undefined || data.length <= 0) { return ; }
				var html = [];
				html.push('<option value="">&nbsp;</option>');
				$.each(data, function (){
					html.push('<option value="' + this.orgId + '" title="' + this.orgNo + '">' + this.name + '</option>');
				});
				$('#' + eleId).html(html.join(''));
		},"json");
	},
	loadDoctor: function (orgId, eleId, defValue) {
		if (orgId == "") {return false;}
		$.post(rootPath + "/sys/queryUserByOrgId.do", {orgId: orgId},
			function(data){
				$('#' + eleId).html('');
				if (null == data || data.length == undefined || data.length <= 0) { return ; }
				var html = [];
				html.push('<option value="">&nbsp;</option>');
				$.each(data, function (){
					if (defValue == this.userInfoId) {
						html.push('<option value="' + this.userInfoId + '" selected="selected">' + this.name + '</option>');
					} else {
						html.push('<option value="' + this.userInfoId + '">' + this.name + '</option>');
					}
				});
				$('#' + eleId).html(html.join(''));
		},"json");
	},
	// 向上拖动加载数据
	initDropload: function (url, queryParam, container, callBack){
		$(container).dropload({
	        scrollArea : window,
	        loadDownFn : function(me){
	        	// 解决点击查询出现多个暂无数据的问题
	        	if ($('.dropload-down').length > 1) {
    				$('.dropload-down').get(0).remove();
    			}
	        	
	        	if (queryParam.pageNumber > queryParam.total) {
	                me.lock();
	                //me.noData();
	    			$('.dropload-down').hide();
	        		return ;
	        	}
	        	queryParam.pageNumber =  queryParam.pageNumber + 1;
	            $.post(
	            	url,
            		queryParam,
    				function (data){
	            		queryParam.total = data.total/queryParam.pageSize;
    					if (data.rows.length != undefined && data.rows.length < queryParam.pageSize) {
	            			me.lock();
	            			if (data.rows.length <= 0) {
    							me.noData();
    						} else {
    							$('.dropload-down').hide();
    						}
	            		}
    					
    					//加载临时字典数据
    					if (null != data.dicMap && data.dicMap != undefined && data.dicMap != "") {
    						common.dicDataMap = data.dicMap;
    					}
    					
    					callBack(me, data.rows);
    					me.resetload();
    				},
    				"json"
	    		);
	        }
	    });
	}
}
// 扩展JQ方法，该方主要用于将表单序列化成json对象，用法: #('#form').serializeObject()
jQuery.prototype.serializeObject=function(){  
    var obj=new Object();  
    $.each(this.serializeArray(),function(index,param){  
        if(!(param.name in obj)){  
            obj[param.name] = param.value;  
        }  
    });  
    return obj;  
};