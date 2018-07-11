package top.bowenlee.notes.rest;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import top.bowenlee.notes.common.BaseController;
import top.bowenlee.notes.common.UniResult;
import top.bowenlee.notes.param.SaveNotes;
import top.bowenlee.notes.param.vo.NotesVO;
import top.bowenlee.notes.service.NoteService;

@RestController
@RequestMapping(value = "/api/v1/notes")
@Api(value = "/api/v1/notes", description = "笔记")
public class NotesController extends BaseController{
	
	@Autowired
	private NoteService noteService; 
	
	@RequiresAuthentication
	@ApiOperation("获取某天的笔记")
	@GetMapping(value = "/getNotes")
	public UniResult<NotesVO> getNotes(@RequestParam@ApiParam(value = "要查的时间")Date time) {
		return ok(noteService.getNotes(time));
	}
	
	@RequiresAuthentication
	@ApiOperation("保存某天的笔记")
	@GetMapping(value = "/saveNotes")
	public UniResult<Boolean> saveNotes(@RequestParam@ApiParam(value = "时间和笔记字符串")SaveNotes saveNotes) {
		return ok(noteService.saveNotes(saveNotes));
	}
	
}
