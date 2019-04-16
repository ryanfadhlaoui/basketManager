package com.basket.manager.factories;

import com.basket.manager.entities.players.skills.PhysicalSkillsEntity;
import com.basket.manager.entities.players.PlayerEntity;
import com.basket.manager.entities.players.skills.ReboundingSkillsEntity;
import com.basket.manager.entities.teams.OffensiveSkillsEntity;
import com.basket.manager.entities.teams.ShootingSkillsEntity;
import com.basket.manager.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PlayerFactory {

    private final Supplier<String> firstNameSupplier;
    private final Supplier<String> lastNameSupplier;
    private final Supplier<Integer> heightSupplier;

    public PlayerFactory(Supplier<String> firstNameSupplier, Supplier<String> lastNameSupplier) {
        this.firstNameSupplier = firstNameSupplier;
        this.lastNameSupplier = lastNameSupplier;
        heightSupplier = new HeightSupplier();
    }

    public List<PlayerEntity> create(int nbPlayers) {
        List<PlayerEntity> playerEntities = new ArrayList<>();
        for (int i = 0; i < nbPlayers; i++) {
            PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.setFirstName(firstNameSupplier.get());
            playerEntity.setLastName(lastNameSupplier.get());
            playerEntity.setAge(11);
            playerEntity.setHeight(heightSupplier.get());
            createSkills(playerEntity);
            playerEntities.add(playerEntity);
        }
        return playerEntities;
    }

    private void createSkills(PlayerEntity playerEntity) {
        OffensiveSkillsEntity offensiveSkills = createOffensiveSkillsEntity();
        ReboundingSkillsEntity reboundingSkillsEntity = new ReboundingSkillsEntity();
        reboundingSkillsEntity.setPositionTechnics(RandomUtils.rand(1, 25));
        reboundingSkillsEntity.setTiming(RandomUtils.rand(1, 25));
        playerEntity.setReboundingSkills(reboundingSkillsEntity);

        PhysicalSkillsEntity physicalSkillsEntity = new PhysicalSkillsEntity();
        physicalSkillsEntity.setStandingVerticalJump(RandomUtils.rand(1, 25));
        physicalSkillsEntity.setStrength(RandomUtils.rand(1, 25));
        playerEntity.setPhysicalSkills(physicalSkillsEntity);
        playerEntity.setOffensiveSkills(offensiveSkills);
    }

    private OffensiveSkillsEntity createOffensiveSkillsEntity() {
        OffensiveSkillsEntity offensiveSkills = new OffensiveSkillsEntity();
        ShootingSkillsEntity shootingSkills = new ShootingSkillsEntity();
        shootingSkills.setMiDistance(RandomUtils.rand(1, 30));
        shootingSkills.setThreePoint(RandomUtils.rand(1, 20));
        offensiveSkills.setShootingSkills(shootingSkills);
        return offensiveSkills;
    }
}
