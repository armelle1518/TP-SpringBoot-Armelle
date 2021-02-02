package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.mapper.TeamMapper;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @PutMapping("/teams")
    public TeamDto updateTeam(@RequestBody TeamDto teamDto) {
        TeamEntity teamToUpdate = teamMapper.toEntity(teamDto);
        TeamEntity UpdatedTeam = teamService.updateTeam(teamToUpdate);

        return teamMapper.toDto(UpdatedTeam);
    }

    @PostMapping("/teams")
    public TeamDto createTeam(@RequestBody TeamDto teamDto) {
        TeamEntity teamToSave = teamMapper.toEntity(teamDto);
        TeamEntity savedTeam = teamService.insertTeam(teamToSave);

        return teamMapper.toDto(savedTeam);
    }

    @GetMapping("/teams/{id}")
    public TeamDto getTeamById(@PathVariable("id") Long id) {
        TeamEntity teamEntity = teamService.findTeamById(id);
        return teamMapper.toDto(teamEntity);
    }

    @GetMapping("/teams")
    public List<TeamDto> getTeamList() {
        return teamService.findAllTeams().stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/hello")
    public String getTeams() {
        return "Hello world";
    }

    @DeleteMapping("/teams/{id}")
    public boolean deleteTeam(@PathVariable("id") Long id) {
        return teamService.deleteTeamById(id);
    }

}


//@Produces({/*MediaType.APPLICATION_JSON ,*/ MediaType.APPLICATION_XML})
//@RequestMapping(path="getTeamList", produces ="application/json; charset=UTF-8")
//@ResponseBody