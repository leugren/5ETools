package org.devoware.table.model;

import static org.devoware.table.dice.Die.D10;
import static org.devoware.table.dice.Die.D12;
import static org.devoware.table.dice.Die.D4;
import static org.devoware.table.dice.Die.D6;
import static org.devoware.table.dice.Die.D8;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;

public class GemsAndArt {
	
	public static final ValueRangeMap GEMS_10_GP = newValueRangeMap(D12)
			.with(1, "Azurite")
			.with(2, "Banded agate")
			.with(3, "Blue quartz")
			.with(4, "Eye agate")
			.with(5, "Hematite")
			.with(6, "Lapis lazuli")
			.with(7, "Malachite")
			.with(8, "Moss agate")
			.with(9, "Obsidian")
			.with(10, "Rhodocrosite")
			.with(11, "Tiger eye")
			.with(12, "Turquoise")
			.build();
	
	public static final ValueRangeMap GEMS_50_GP = newValueRangeMap(D12)
			.with(1, "Bloodstone")
			.with(2, "Carnelian")
			.with(3, "Chalcedony")
			.with(4, "Chryoprase")
			.with(5, "Citrine")
			.with(6, "Jasper")
			.with(7, "Moonstone")
			.with(8, "Onyx")
			.with(9, "Quartz")
			.with(10, "Sardonyx")
			.with(11, "Star rose quartz")
			.with(12, "Zircon")
			.build();

	public static final ValueRangeMap GEMS_100_GP = newValueRangeMap(D10)
			.with(1, "Amber")
			.with(2, "Amethyst")
			.with(3, "Chrysoberyl")
			.with(4, "Coral")
			.with(5, "Garnet")
			.with(6, "Jade")
			.with(7, "Jet")
			.with(8, "Pearl")
			.with(9, "Spinel")
			.with(10, "Tourmaline")
			.build();

	public static final ValueRangeMap GEMS_500_GP = newValueRangeMap(D6)
			.with(1, "Alexandrite")
			.with(2, "Aquamarine")
			.with(3, "Black pearl")
			.with(4, "Blue spinel")
			.with(5, "Peridot")
			.with(6, "Topaz")
			.build();

	public static final ValueRangeMap GEMS_1000_GP = newValueRangeMap(D8)
			.with(1, "Black opal")
			.with(2, "Blue sapphire")
			.with(3, "Emerald")
			.with(4, "Fire opal")
			.with(5, "Opal")
			.with(6, "Star ruby")
			.with(7, "Star sapphire")
			.with(8, "Yellow sapphire")
			.build();

	public static final ValueRangeMap GEMS_5000_GP = newValueRangeMap(D4)
			.with(1, "Black sapphire")
			.with(2, "Diamond")
			.with(3, "Jacinth")
			.with(4, "Ruby")
			.build();

	public static final ValueRangeMap ART_25_GP = newValueRangeMap(D10)
			.with(1, "Silver ewer (25 gp)")
			.with(2, "Carved bone statuette (25 gp)")
			.with(3, "Small gold bracelet (25 gp)")
			.with(4, "Cloth-of-gold vestments (25 gp)")
			.with(5, "Black velvet mask stitched with silver thread (25 gp)")
			.with(6, "Copper chalice with silver filigree (25 gp)")
			.with(7, "Pair of engraved bone dice (25 gp)")
			.with(8, "Small mirror set in a painted wooden frame (25 gp)")
			.with(9, "Embroidered silk handkerchief (25 gp)")
			.with(10, "Gold locket with a painted portrait inside (25 gp)")
			.build();

	public static final ValueRangeMap ART_250_GP = newValueRangeMap(D10)
			.with(1, "Gold ring set with bloodstones (250 gp)")
			.with(2, "Carved ivory statuette (250 gp)")
			.with(3, "Large gold bracelet (250 gp)")
			.with(4, "Silver necklace with a gemstone pendant (250 gp)")
			.with(5, "Bronze crown (250 gp)")
			.with(6, "Silk robe with gold embroidery (250 gp)")
			.with(7, "Large well-made tapestry (250 gp)")
			.with(8, "Brass mug with jade inlay (250 gp)")
			.with(9, "Box or turquoise animal figurines (250 gp)")
			.with(10, "Gold bird cage with electrum filigree (250 gp)")
			.build();
	public static final ValueRangeMap ART_750_GP = newValueRangeMap(D10)
			.with(1, "Silver chalice set with moonstones (750 gp)")
			.with(2, "Silver-plated steel longsword with jet set in hilt (750 gp)")
			.with(3, "Carved harp of exotic wood with ivory inlay and zircon gems (750 gp)")
			.with(4, "Small gold idol (750 gp)")
			.with(5, "Gold dragon comb set with red garnets as eyes (750 gp)")
			.with(6, "Bottle stopper cork embossed with gold leaf and set with amethysts (750 gp)")
			.with(7, "Ceremonial electrum dagger with a black pearl in the pommel (750 gp)")
			.with(8, "Silver and gold brooch (750 gp)")
			.with(9, "Obsidian statuette with gold fittings and inlay (750 gp)")
			.with(10, "Painted gold war mask (750 gp)")
			.build();
	
	public static final ValueRangeMap ART_2500_GP = newValueRangeMap(D10)
			.with(1, "Fine gold chain set with a fire opal (2,500 gp)")
			.with(2, "Old masterpiece painting (2,500 gp)")
			.with(3, "Embroidered silk and velvet mantle set with numerous moonstones (2,500 gp)")
			.with(4, "Platinum bracelet set with a sapphire (2,500 gp)")
			.with(5, "Embroidered glove set with jewel chips (2,500 gp)")
			.with(6, "Jeweled anklet (2,500 gp)")
			.with(7, "Gold music box (2,500 gp)")
			.with(8, "Gold circlet set with four aquamarines (2,500 gp)")
			.with(9, "Eye patch with a mock eye set in blue sapphire and moonstone (2,500 gp)")
			.with(10, "A necklace string of small pink pearls (2,500 gp)")
			.build();
	
	public static final ValueRangeMap ART_7500_GP = newValueRangeMap(D8)
			.with(1, "Jeweled gold crown (7,500 gp)")
			.with(2, "Jeweled platinum ring (7,500 gp)")
			.with(3, "Small gold statuette set with rubies (7,500 gp)")
			.with(4, "Gold cup set with emeralds (7,500 gp)")
			.with(5, "Gold jewelry box with platinum filigree (7,500 gp)")
			.with(6, "Painted gold child's sarcophagus (7,500 gp)")
			.with(7, "Jade game board with solid gold playing pieces (7,500 gp)")
			.with(8, "Bejeweled ivory drinking horn with gold filigree (7,500 gp)")
			.build();

	private GemsAndArt () {}
}
