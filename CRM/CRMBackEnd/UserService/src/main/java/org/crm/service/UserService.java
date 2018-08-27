package org.crm.service;
import org.crm.domain.SysUser;
import java.util.List;

public interface UserService {
    public SysUser findByNameAndPwd(String usr_name, String usr_password);
    public List<SysUser> findAllSysUser();//查询所有用户
    public SysUser findById(int usr_id);
    public  SysUser getUserByToken(String token);
    public void logOut(String token);
}
