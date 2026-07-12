package ru.myst.model;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MystType {

    private final String id;
    private String displayName;
    private String hologramFormat;
    private String hologramOpeningFormat;
    private String hologramOpenFormat;
    private int countdownBeforeOpenSeconds;
    private int openDurationSeconds;
    private boolean security;
    private boolean kd;
    private boolean use;
    private Material treasureItem;
    private String treasureName;
    private final List<LootEntry> loot = new ArrayList<>();

    // ----- авто-спавн -----
    private boolean autoSpawn = false;
    private int autoSpawnIntervalSeconds = 600;
    private int autoSpawnRadius = 7; // ~15x15x15 зона (радиус в каждую сторону)
    private String regionWorld;
    private Integer regionX;
    private Integer regionY;
    private Integer regionZ;

    public MystType(String id) {
        this.id = id;
        this.displayName = "&a" + id;
        this.hologramFormat = "&e&l{name}";
        this.hologramOpeningFormat = "&7Откроется через: &f{time}";
        this.hologramOpenFormat = "&aЗакроется через: &f{time}";
        this.countdownBeforeOpenSeconds = 15;
        this.openDurationSeconds = 300;
        this.security = true;
        this.kd = true;
        this.use = false;
        this.treasureItem = Material.PHANTOM_MEMBRANE;
        this.treasureName = "&6Сокровище";
    }

    public ItemStackRoll rollLoot(Random random) {
        int totalWeight = loot.stream().mapToInt(LootEntry::getWeight).sum();
        if (totalWeight <
