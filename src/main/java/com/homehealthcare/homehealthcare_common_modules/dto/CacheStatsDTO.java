package com.homehealthcare.homehealthcare_common_modules.dto;

import com.github.benmanes.caffeine.cache.stats.CacheStats;
import lombok.Getter;

@Getter
public class CacheStatsDTO {

    private final long hitCount;
    private final long missCount;
    private final double hitRate;
    private final double missRate;
    private final long loadSuccessCount;
    private final long loadFailureCount;
    private final long totalLoadTime;
    private final long evictionCount;

    public CacheStatsDTO(CacheStats stats) {
        this.hitCount = stats.hitCount();
        this.missCount = stats.missCount();
        this.hitRate = stats.hitRate();
        this.missRate = stats.missRate();
        this.loadSuccessCount = stats.loadSuccessCount();
        this.loadFailureCount = stats.loadFailureCount();
        this.totalLoadTime = stats.totalLoadTime();
        this.evictionCount = stats.evictionCount();
    }
}
