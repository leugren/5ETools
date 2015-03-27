package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class EncounterStats {
	
	private final int baseXps;
	private final int adjustedXps;
	private final DifficultyLevel difficultyLevel;
	private final Map<DifficultyLevel, Integer> difficultyThresholds;
	
	public static Builder builder () {
		return new Builder();
	}
	
	private EncounterStats (Builder builder) {
		this.baseXps = builder.baseXps;
		this.adjustedXps = builder.adjustedXps;
		this.difficultyLevel = builder.difficultyLevel;
		this.difficultyThresholds = ImmutableMap.copyOf(builder.difficultyThresholds);
	}
	
	public int getBaseXps() {
		return baseXps;
	}

	public int getAdjustedXps() {
		return adjustedXps;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public Map<DifficultyLevel, Integer> getDifficultyThresholds() {
		return difficultyThresholds;
	}

	@Override
	public String toString() {
		return "EncounterStats [baseXps=" + baseXps + ", adjustedXps="
				+ adjustedXps + ", difficultyLevel=" + difficultyLevel
				+ ", difficultyThresholds=" + difficultyThresholds + "]";
	}



	public static class Builder {
		private Integer baseXps;
		private Integer adjustedXps;
		private DifficultyLevel difficultyLevel;
		private Map<DifficultyLevel, Integer> difficultyThresholds = Maps.newLinkedHashMap();
		
		private Builder () {}
		
		public Builder withBaseXps(int baseXps) {
			this.baseXps = baseXps;
			return this;
		}

		public Builder withAdjustedXps(int adjustedXps) {
			this.adjustedXps = adjustedXps;
			return this;
		}
		
		public Builder withDifficultyLevel(DifficultyLevel difficultyLevel) {
			this.difficultyLevel = difficultyLevel;
			return this;
        }
		
		public Builder withDifficultyThresholds(
				Map<DifficultyLevel, Integer> difficultyThresholds) {
			this.difficultyThresholds.clear();
			this.difficultyThresholds.putAll(difficultyThresholds);
			return this;
        }
		
		public EncounterStats build () {
			checkNotNull(this.baseXps);
			checkNotNull(this.adjustedXps);
			checkNotNull(this.difficultyLevel);
			checkArgument(!this.difficultyThresholds.isEmpty());
			
			return new EncounterStats(this);
		}
		
		
		
	}

}
