package com.bofan.his.command;

import com.bofan.basesystem.common.command.BaseCommandInfo;
import com.bofan.infoql.QueryInfo;

/**
 * 
 * @author xlf
 *
 */
@SuppressWarnings("serial")
@QueryInfo(from = "com.bofan.his.valueobject.MedicalInstitution", orderBy = "hospitalNo asc")
public class MedicalInstitutionQueryInfo extends BaseCommandInfo {

    
}
