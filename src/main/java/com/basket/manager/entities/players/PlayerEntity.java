package com.basket.manager.entities.players;

import com.basket.manager.entities.GenericEntity;
import com.basket.manager.entities.players.skills.PhysicalSkillsEntity;
import com.basket.manager.entities.players.skills.ReboundingSkillsEntity;
import com.basket.manager.entities.players.skills.TechnicalSkillsEntity;
import com.basket.manager.entities.teams.OffensiveSkillsEntity;

import javax.persistence.*;

@Entity(name = "PlayerEntity")
@Table(name = "player")
@NamedQueries({
        @NamedQuery(name = "player.gePlayerWithoutTeam", query = "SELECT p FROM PlayerEntity p " +
                "LEFT JOIN TeamPlayerEntity tp on tp.playerEntity.id = p.id " +
                "WHERE tp.id IS NULL"),
})
public class PlayerEntity implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int age;

    /**
     * La taille en cm.
     */
    private Integer height;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offensive_skills_id")
    private OffensiveSkillsEntity offensiveSkills;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "technical_skills_id")
    private TechnicalSkillsEntity technicalSkills;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rebounding_skills_id")
    private ReboundingSkillsEntity reboundingSkills;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_skills_id")
    private PhysicalSkillsEntity physicalSkills;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public OffensiveSkillsEntity getOffensiveSkills() {
        return offensiveSkills;
    }

    public void setOffensiveSkills(OffensiveSkillsEntity offensiveSkills) {
        this.offensiveSkills = offensiveSkills;
    }

    public ReboundingSkillsEntity getReboundingSkills() {
        return reboundingSkills;
    }

    public void setReboundingSkills(ReboundingSkillsEntity reboundingSkills) {
        this.reboundingSkills = reboundingSkills;
    }

    public PhysicalSkillsEntity getPhysicalSkills() {
        return physicalSkills;
    }

    public void setPhysicalSkills(PhysicalSkillsEntity physicalSkills) {
        this.physicalSkills = physicalSkills;
    }

    public TechnicalSkillsEntity getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(TechnicalSkillsEntity technicalSkills) {
        this.technicalSkills = technicalSkills;
    }
}
