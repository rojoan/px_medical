package com.bofan.emergencyevent.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bofan.basesystem.common.command.Page;
import com.bofan.basesystem.common.service.spring.AbstractAnnoCommonService;
import com.bofan.basesystem.common.utils.IQueryObject;
import com.bofan.emergencyevent.command.EmProfessorEditInfo;
import com.bofan.emergencyevent.command.EmProfessorQueryInfo;
import com.bofan.emergencyevent.valueobject.EmProfessor;
import com.bofan.utils.NullBeanUtils;

/**
 * @Description: 专家信息业务
 * @author lqw
 */
@Service
@Transactional
public class EmProfessorService extends AbstractAnnoCommonService {

	/**
	 * 根据条件查询专家信息分页记录
	 * 
	 * @param info
	 * @return
	 */
	public Page selectEmProfessorList(EmProfessorQueryInfo info) { 
		IQueryObject qo = super.getQueryObject(info);
		return super.find(qo.getQueryString(), qo.getParam(), info.getPageNumber(), info.getPageSize());
	}

	/**
	 * 根据id查询专家信息
	 * @param professorId
	 * @return
	 */
	public EmProfessor selectEmProfessorById(Long professorId) {
		return super.load(EmProfessor.class, professorId);
	}

	/**
	 * 保存专家信息
	 */
	public EmProfessor saveEmProfessor(EmProfessorEditInfo editInfo) {
		EmProfessor emProfessor = null;
		if (null != editInfo.getProfessorId()) {
			emProfessor = this.selectEmProfessorById(editInfo.getProfessorId());
		} else {
			emProfessor = new EmProfessor();
		}

		NullBeanUtils.copyProperties(emProfessor, editInfo);
		super.save(emProfessor);
		return emProfessor;
	}
 

}
