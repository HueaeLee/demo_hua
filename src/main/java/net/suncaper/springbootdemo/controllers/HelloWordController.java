package net.suncaper.springbootdemo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.suncaper.springbootdemo.pojo.SysRole;
import net.suncaper.springbootdemo.services.interfaces.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/helloworld")
public class HelloWordController {

    @Autowired
    private SysRoleService service;

    @RequestMapping("/hello")
    public String helloworld(){
        return "helloworld";
    }

    /**
     * 根据id查询角色详细信息
     * @param id
     * @return
     */
    @RequestMapping("/role/{id}")
    public SysRole selectRoleById(@PathVariable("id") String id){
        return service.selectSysRoleById(id);
    }

    @RequestMapping("/role/list")
    public List<SysRole> selectRoleList(SysRole role){
        return service.selectRoleList(role);
    }
    @RequestMapping("/role/list2")
    public void selectRoleList2(HttpServletRequest request, HttpServletResponse response){
        SysRole role = new SysRole();
        if(request.getParameter("rolename")!=null){
            role.setRolename(request.getParameter("rolename"));
        }
        if(request.getParameter("rolestate")!=null){
            role.setRolestate(Integer.parseInt(request.getParameter("rolestate")));
        }
        List<SysRole> list = service.selectRoleList(role);
        ObjectMapper om = new ObjectMapper();
        try {
            String str = om.writeValueAsString(list);
            PrintWriter out = response.getWriter();
            out.write(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
