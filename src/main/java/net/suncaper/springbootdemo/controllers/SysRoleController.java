package net.suncaper.springbootdemo.controllers;

import net.suncaper.springbootdemo.pojo.SysRole;
import net.suncaper.springbootdemo.services.interfaces.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/sys/role")
public class SysRoleController {
    @Autowired
    private SysRoleService service;
    /**
     * 进入到增加页面的方法
     * @return 表示视图的地址
     */

    @RequestMapping("/toadd")
    public String toadd(){
        return "/sys/role/add.html";
    }

    /**
     * 增加角色
     * @param role
     * @return
     */
    @RequestMapping("/add")
    public String add(SysRole role, Model model){
        role.setRoleid(UUID.randomUUID().toString());
        int rtn = service.insertRole(role);
        if(rtn>0){
            model.addAttribute("msg","保存成功");
        }else{
            model.addAttribute("msg","保存失败");
        }
        return "/sys/role/add.html";
    }

    /**
     * 查询角色列表
     * @param role
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String selectRoleList(SysRole role,Model model){
        List<SysRole> list = service.selectRoleList(role);
        model.addAttribute("list",list);
        return "/sys/role/list.html";
    }

    /**
     * 初始化修改页面
     * @param id
     * @return
     */
    @RequestMapping("/toedit")
    public String toedit(String id, Model model){
        SysRole role = service.selectSysRoleById(id);
        model.addAttribute("role",role);
        return "/sys/role/edit.html";
    }

    @RequestMapping("/toedit1/{id}")
    public String restToEdit(@PathVariable("id")String id,Model model){
        SysRole role = service.selectSysRoleById(id);
        model.addAttribute("role",role);
        return "/sys/role/edit.html";
    }

    /**
     * 修改系统觉额
     * @param role
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String edit(SysRole role,Model model){
        int rtn = service.updateRole(role);
        if(rtn>0){
            return "redirect:/sys/role/list";
        }else{
            model.addAttribute("msg","修改角色失败");
            return "forward:/sys/role/toedit/"+role.getRoleid();
        }
    }
}
