package top.bowenlee.notes.service;

import java.util.List;

import top.bowenlee.notes.param.Register;
import top.bowenlee.notes.param.SignIn;
import top.bowenlee.notes.param.vo.NotesVO;

public interface LoginService{

	/**认证 同时返回时间戳笔记
	 * @param signIn
	 * @return
	 */
	public List<NotesVO> signIn(SignIn signIn);

	/**注册
	 * @param register
	 */
	public void register(Register register);
	
	/**检验昵称是否可用
	 * @param name
	 * @return 可用
	 */
	public Boolean checkName(String name);

	/**获取用户信息
	 * @param name
	 * @return 返回用户密码和盐
	 */
	public String getUser(String name);

}
