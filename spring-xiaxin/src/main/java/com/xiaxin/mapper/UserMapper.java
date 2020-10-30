package com.xiaxin.mapper;

import java.util.List;

import com.xiaxin.mapperScan.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cxq
 * @date 2020/9/10 17:06
 * @description
 */
@Mapper
public interface UserMapper {

	@Select("select * from sys_user")
	List<SysUser> listSysUser();

}
