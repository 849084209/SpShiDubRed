package top.bowenlee.notes.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;

import top.bowenlee.notes.param.SaveNotes;
import top.bowenlee.notes.param.vo.NoteVO;
import top.bowenlee.notes.param.vo.NotesVO;
import top.bowenlee.notes.service.NoteService;
import top.bowenlee.notes.util.CommonUitl;

@SuppressWarnings({"rawtypes","unchecked"})
public class NoteServiceImpl implements NoteService{

	@Autowired
	private RedisTemplate template;
	
	@Override
	public Boolean saveNotes(SaveNotes saveNotes){
		CommonUitl.checkNotesStr(saveNotes.getNotesStr());
		String name = (String)SecurityUtils.getSubject().getPrincipal();
		ValueOperations<String,String> opsForValue = template.opsForValue();
		opsForValue.set(name+CommonUitl.getNowDate(saveNotes.getTime()),saveNotes.getNotesStr());
		return StringUtils.isEmpty(opsForValue.get(name+CommonUitl.getNowDate(saveNotes.getTime())));
	}
	
	@Override
	public NotesVO getNotes(Date time){
		NotesVO notesVO = new NotesVO();
		String name = (String)SecurityUtils.getSubject().getPrincipal();
		ValueOperations<String,String> opsForValue = template.opsForValue();
		String string = opsForValue.get(name+CommonUitl.getNowDate(time));
		notesVO.setDateTime(time);
		List<NoteVO> noteVOs = new ArrayList<NoteVO>();
		String[] notes = string.split(";");
		for (String note : notes) {
			String[] context = note.split("/");
			NoteVO noteVO = new NoteVO();
			noteVO.setContext(context[0]);
			noteVO.setStatus(context[1]);
			noteVOs.add(noteVO);
		}
		return notesVO;
	}
	
}
