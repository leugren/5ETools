package org.devoware.table.model;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Optional;

public class Background {
	private final String name;
	private final RandomizableStringSource traits;
	private final IdealSet ideals;
	private final RandomizableStringSource bonds;
	private final RandomizableStringSource flaws;
	private final Optional<NamedRandomizableStringSource> additionalTable;

	public static Builder newBackground () {
		return new Builder();
	}
	
	private Background (Builder builder) {
		this.name = builder.name;
		this.traits = builder.traits;
		this.ideals = builder.ideals;
		this.bonds = builder.bonds;
		this.flaws = builder.flaws;
		if (builder.additionalTable == null) {
			this.additionalTable = Optional.absent();
		} else {
		    this.additionalTable = Optional.of(builder.additionalTable);
		}
	}
	
	public String getName () {
		return this.name;
	}
	
	public RandomizableStringSource getPersonalityTraits () {
		return this.traits;
	}
	
	public IdealSet getIdeals () {
		return this.ideals;
	}

	public RandomizableStringSource getBond () {
		return this.bonds;
	}
	
	public RandomizableStringSource getFlaw () {
		return this.flaws;
	}
	
	public Optional<NamedRandomizableStringSource> getAdditionalTable () {
		return this.additionalTable;
	}

	public static class Builder {
		private String name;
		private RandomizableStringSource traits;
		private IdealSet ideals;
		private RandomizableStringSource bonds;
		private RandomizableStringSource flaws;
		private NamedRandomizableStringSource additionalTable;
		
		private Builder () {}

		public Builder withName (String name) {
			checkNotNull(name);
			this.name = name;
			return this;
		}

		public Builder withTraits(RandomizableStringSource traits) {
			checkNotNull(traits);
			this.traits = traits;
			return this;
		}

		public Builder withIdeals(IdealSet ideals) {
			checkNotNull(ideals);
			this.ideals = ideals;
			return this;
		}

		public Builder withBonds(RandomizableStringSource bonds) {
			checkNotNull(bonds);
			this.bonds = bonds;
			return this;
		}

		public Builder withFlaws(RandomizableStringSource flaws) {
			checkNotNull(flaws);
			this.flaws = flaws;
			return this;
		}
		
		public Builder withAdditionalTable(NamedRandomizableStringSource table) {
			checkNotNull(table);
			this.additionalTable = table;
			return this;
		}
		
		public Background build () {
			checkNotNull(name);
			checkNotNull(traits);
			checkNotNull(ideals);
			checkNotNull(bonds);
			checkNotNull(flaws);
			return new Background(this);
		}
		
		
		
	}
}
