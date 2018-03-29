package de.frena.holidayreplacement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.frena.holidayreplacement.dto.MyTaskDto;
import de.frena.holidayreplacement.service.NameGeneratorService;
import de.frena.holidayreplacement.service.UserManager;
import de.frena.holidayreplacement.service.UserTaskManager;

@Controller
public class HolidayReplacementController {

	public static final String ADD_SUBSTITUTE = "/add";
	public static final String ADD_SUBSTITUTE_SINGLE_TASK = "/addForTask";
	public static final String TASKLIST = "/tasklist";

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserTaskManager userTaskManager;
	
	@Autowired
	private NameGeneratorService nameGeneratorService;

	
	/**
	 *	http://localhost:8081/tasklist?user=jack
	 */
	@ResponseBody
	@RequestMapping(value = TASKLIST, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MyTaskDto> getCandidateTasksForUser(@RequestParam (value= "user") String userId) throws InterruptedException {
		return userTaskManager.getCandidateTasksForUser(userId);
	}

	
	/**
	 * 	http://localhost:8081/add?substitute=john&forUserId=jack&forRole=coordinator
	 */
	@ResponseBody
	@RequestMapping(value = ADD_SUBSTITUTE, method = RequestMethod.GET)
	public String addSubstitute(
	@RequestParam (value= "substitute") String substituteUserId, //
    @RequestParam (value = "forUserId") String forUserId,
    @RequestParam (value = "forRole") String forRole) throws InterruptedException {
		
		if("coordinator".equals(forRole)){
			String groupName = nameGeneratorService.groupName(forUserId, forRole);
			userManager.createGroupIfNotExists(groupName);
			userManager.createUserIfNotExists(substituteUserId);
			userManager.createMembershipIfNotExists(substituteUserId, groupName);
			return substituteUserId + " now substitute for "+ forUserId + " for role "+ forRole;
		}
		return "undefined role";
	}

	
	/**
	 *	http://localhost:8081/addForTask?user=paul&taskId=<xxx>
	 */
	@ResponseBody
	@RequestMapping(value = ADD_SUBSTITUTE_SINGLE_TASK, method = RequestMethod.GET)
	public void addInterventionUserForCertainTasks(
			@RequestParam (value= "user") String userId, //
			@RequestParam (value = "taskId") String taskId) throws InterruptedException {
		userManager.createUserIfNotExists(userId);
		userTaskManager.setCandidateUser(userId, taskId);
	}
}
