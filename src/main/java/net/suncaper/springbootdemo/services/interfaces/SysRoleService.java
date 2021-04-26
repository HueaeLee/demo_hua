package net.suncaper.springbootdemo.services.interfaces;

import net.suncaper.springbootdemo.pojo.SysRole;

import java.util.List;

/**
 * 角色管理service层接口
 */
public interface SysRoleService {
    /**
     * 根据角色id查询角色的详细信息
     * @param id
     * @return
     */
    SysRole selectSysRoleById(String id);

    /**
     * 查询角色列表
     * @param role
     * @return
     */
    List<SysRole> selectRoleList(SysRole role);

    /**
     * 增加角色
     * @param role
     * @return
     */
    int insertRole(SysRole role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    int updateRole(SysRole role);

}
