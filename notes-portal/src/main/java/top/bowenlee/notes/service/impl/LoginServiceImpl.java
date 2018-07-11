package top.bowenlee.notes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import top.bowenlee.notes.exception.ShiroException;
import top.bowenlee.notes.param.Register;
import top.bowenlee.notes.param.SignIn;
import top.bowenlee.notes.param.vo.NoteVO;
import top.bowenlee.notes.param.vo.NotesVO;
import top.bowenlee.notes.service.LoginService;
import top.bowenlee.notes.util.CommonUitl;
import top.bowenlee.notes.util.SaltFactory;

@SuppressWarnings({"rawtypes","unchecked"})
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private RedisTemplate template;
	
	@Override
	public List<NotesVO> signIn(SignIn signIn){
		List<NotesVO> notesList = new ArrayList<NotesVO>();
		ValueOperations<String, List<String>> opsForValue = template.opsForValue();
		List<String> list = opsForValue.get(signIn.getKey());
		if(!CollectionUtils.isEmpty(list)){
			for (String string : list) {
				String[] date = string.split("-");
				NotesVO notesVO = new NotesVO();
				notesVO.setDateTime(CommonUitl.getNowDate(date[0]));
				List<NoteVO> noteVOs = new ArrayList<NoteVO>();
				String[] notes = date[1].split(";");
				for (String note : notes) {
					String[] context = note.split("/");
					NoteVO noteVO = new NoteVO();
					noteVO.setContext(context[0]);
					noteVO.setStatus(context[1]);
					noteVOs.add(noteVO);
				}
				notesList.add(notesVO);
			}
		}
		return notesList;
	}
		
	@Override
	public void register(Register register){
		ValueOperations<String, String> opsForValue = template.opsForValue();
		String pas = SaltFactory.getPas(register.getPasWord());
		opsForValue.set(register.getName(),pas);
		if(StringUtils.isEmpty(opsForValue.get(register.getName()))){
			throw new ShiroException(ShiroException.SAVE);
		}
	}

	@Override
	public Boolean checkName(String name) {
		ValueOperations<String, String> opsForValue = template.opsForValue();
		return StringUtils.isEmpty(opsForValue.get(name));
	}
	
	@Override
	public String getUser(String name) {
		ValueOperations<String, String> opsForValue = template.opsForValue();
		String string = opsForValue.get(name);
		return string;
	}
	
}
