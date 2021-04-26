package net.suncaper.springbootdemo.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.suncaper.springbootdemo.dao.SysRoleMapper;
import net.suncaper.springbootdemo.pojo.SysRole;
import net.suncaper.springbootdemo.services.interfaces.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色管理service层实现类
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper mapper;
    /**
     * 根据角色id查询角色的详细信息
     *
     * @param id
     * @return
     */
    @Override
    public SysRole selectSysRoleById(String id) {
        return mapper.selectById(id);
    }

    @Override
    public List<SysRole> selectRoleList(SysRole role){
        QueryWrapper<SysRole> wapper = new QueryWrapper<SysRole>();
        if(role!=null){
            if(role.getRolestate()!=null && role.getRolestate()!=-1){
                wapper.eq("rolestate",role.getRolestate());
            }
            if(role.getRolename()!=null && !role.getRolename().equals("")){
                wapper.like("rolename","%"+role.getRolename()+"%");
            }
        }
        return mapper.selectList(wapper);
    }

    /**
     * 增加角色
     *
     * @param role
     * @return
     */
    @Override
    public int insertRole(SysRole role) {
        return mapper.insert(role);
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @Override
    public int updateRole(SysRole role) {
        return mapper.updateById(role);
    }
}
