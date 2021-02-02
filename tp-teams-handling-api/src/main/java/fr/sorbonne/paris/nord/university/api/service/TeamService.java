package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamService {

    @Autowired
    private final TeamRepository teamRepository;


    public TeamService ( TeamRepository teamRepository ){
        this.teamRepository = teamRepository ;
    }

    public List<TeamEntity> findAllTeams() {
        return teamRepository.findAll();
    }

    public TeamEntity findTeamById( Long id ){
      return (TeamEntity) teamRepository.findById(id).orElse(null);
    }

    @Transactional
    public TeamEntity insertTeam( TeamEntity teamEntity){
        return teamRepository.save(teamEntity);
    }

    @Transactional
    public TeamEntity updateTeam ( TeamEntity updated){
        return teamRepository.save(updated);
    }

    public boolean deleteTeamById( Long id){
        teamRepository.deleteById(id);
        TeamEntity teamEntity = this.findTeamById(id);
        if(teamEntity == null){
            return true;
        }else{
            return false;
        }
    }
}
