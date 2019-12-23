package com.lilithsthrone.game.character.npc.submission;

import java.time.Month;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.lilithsthrone.game.Game;
import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.EquipClothingSetting;
import com.lilithsthrone.game.character.body.Covering;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.types.PenisType;
import com.lilithsthrone.game.character.body.valueEnums.AreolaeSize;
import com.lilithsthrone.game.character.body.valueEnums.AssSize;
import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.valueEnums.BodySize;
import com.lilithsthrone.game.character.body.valueEnums.BreastShape;
import com.lilithsthrone.game.character.body.valueEnums.Capacity;
import com.lilithsthrone.game.character.body.valueEnums.ClitorisSize;
import com.lilithsthrone.game.character.body.valueEnums.CumProduction;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.HairLength;
import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
import com.lilithsthrone.game.character.body.valueEnums.HipSize;
import com.lilithsthrone.game.character.body.valueEnums.LabiaSize;
import com.lilithsthrone.game.character.body.valueEnums.LipSize;
import com.lilithsthrone.game.character.body.valueEnums.Muscle;
import com.lilithsthrone.game.character.body.valueEnums.NippleSize;
import com.lilithsthrone.game.character.body.valueEnums.OrificeElasticity;
import com.lilithsthrone.game.character.body.valueEnums.OrificePlasticity;
import com.lilithsthrone.game.character.body.valueEnums.PenisGirth;
import com.lilithsthrone.game.character.body.valueEnums.TesticleSize;
import com.lilithsthrone.game.character.body.valueEnums.TongueLength;
import com.lilithsthrone.game.character.body.valueEnums.Wetness;
import com.lilithsthrone.game.character.effects.PerkCategory;
import com.lilithsthrone.game.character.effects.PerkManager;
import com.lilithsthrone.game.character.fetishes.Fetish;
import com.lilithsthrone.game.character.fetishes.FetishDesire;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.markings.Scar;
import com.lilithsthrone.game.character.markings.ScarType;
import com.lilithsthrone.game.character.markings.Tattoo;
import com.lilithsthrone.game.character.markings.TattooType;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.persona.NameTriplet;
import com.lilithsthrone.game.character.persona.Occupation;
import com.lilithsthrone.game.character.persona.PersonalityTrait;
import com.lilithsthrone.game.character.persona.SexualOrientation;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.places.submission.ratWarrens.RatWarrensCaptiveDialogue;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

/**
 * @since 0.3.5.5
 * @version 0.3.5.5
 * @author Innoxia
 */
public class Murk extends NPC {

	public Murk() {
		this(false);
	}
	
	public Murk(boolean isImported) {
		super(isImported, new NameTriplet("Murk", "Missy", "Missy"), "Triche",
				"",
				27, Month.DECEMBER, 22,
				10, Gender.M_P_MALE, Subspecies.RAT_MORPH, RaceStage.GREATER,
				new CharacterInventory(2500), WorldType.RAT_WARRENS, PlaceType.RAT_WARRENS_MILKING_STORAGE, true);
	}
	
	@Override
	public void loadFromXML(Element parentElement, Document doc, CharacterImportSetting... settings) {
		loadNPCVariablesFromXML(this, null, parentElement, doc, settings);
		if(Main.isVersionOlderThan(Game.loadingVersion, "0.3.5.6")) { // Reset character
			setupPerks(true);
			setStartingBody(true);
			equipClothing(null);
		}
	}

	@Override
	public void setupPerks(boolean autoSelectPerks) {
		PerkManager.initialisePerks(this,
				Util.newArrayListOfValues(),
				Util.newHashMapOfValues(
						new Value<>(PerkCategory.PHYSICAL, 1),
						new Value<>(PerkCategory.LUST, 0),
						new Value<>(PerkCategory.ARCANE, 0)));
	}

	@Override
	public void setStartingBody(boolean setPersona) {
		// Persona:
		if(setPersona) {
			this.clearPersonalityTraits();
			this.clearFetishes();
			this.clearFetishDesires();
			
			this.setPersonalityTraits(
					PersonalityTrait.COWARDLY,
					PersonalityTrait.LEWD,
					PersonalityTrait.SELFISH);
			
			this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
			
			this.setHistory(Occupation.NPC_GANG_MEMBER);
	
			this.addFetish(Fetish.FETISH_DOMINANT);
			this.addFetish(Fetish.FETISH_SADIST);
			this.addFetish(Fetish.FETISH_EXHIBITIONIST);
			
			this.setFetishDesire(Fetish.FETISH_CUM_STUD, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_VAGINAL_GIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_ANAL_GIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_IMPREGNATION, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_SUBMISSIVE, FetishDesire.ZERO_HATE);
			this.setFetishDesire(Fetish.FETISH_MASOCHIST, FetishDesire.ZERO_HATE);
		}
		
		// Body:
		// Core:
		this.setHeight(146);
		this.setFemininity(30);
		this.setMuscle(Muscle.ZERO_SOFT.getMedianValue());
		this.setBodySize(BodySize.TWO_AVERAGE.getMedianValue());
		
		// Coverings:
		this.setSkinCovering(new Covering(BodyCoveringType.EYE_RAT, Colour.EYE_YELLOW), true);
		this.setSkinCovering(new Covering(BodyCoveringType.RAT_FUR, Colour.COVERING_BLACK), true);
		this.setSkinCovering(new Covering(BodyCoveringType.RAT_SKIN, Colour.SKIN_PINK_LIGHT), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, Colour.SKIN_EBONY), true);
		this.setSkinCovering(new Covering(BodyCoveringType.PENIS, Colour.SKIN_EBONY), false);
		this.setHairCovering(new Covering(BodyCoveringType.HAIR_RAT_FUR, Colour.COVERING_BLACK), false);
		this.setHairLength(0);
		this.setHairStyle(HairStyle.NONE);

		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_RAT_FUR, Colour.COVERING_BLACK), false);
		this.setUnderarmHair(BodyHair.FOUR_NATURAL);
		this.setAssHair(BodyHair.FOUR_NATURAL);
		this.setPubicHair(BodyHair.FOUR_NATURAL);
		this.setFacialHair(BodyHair.ZERO_NONE);

		// Face:
		this.setFaceVirgin(true);
		this.setLipSize(LipSize.ONE_AVERAGE);
		this.setFaceCapacity(Capacity.ZERO_IMPENETRABLE, true);
		this.setTongueLength(TongueLength.ZERO_NORMAL.getMedianValue());
		
		// Chest:
		this.setNippleVirgin(true);
		this.setBreastSize(CupSize.FLAT.getMeasurement());
		this.setBreastShape(BreastShape.POINTY);
		this.setNippleSize(NippleSize.ZERO_TINY);
		this.setAreolaeSize(AreolaeSize.ZERO_TINY);
		
		// Ass:
		this.setAssVirgin(true);
		this.setAssBleached(false);
		this.setAssSize(AssSize.THREE_NORMAL);
		this.setHipSize(HipSize.TWO_NARROW);
		this.setAssCapacity(Capacity.ZERO_IMPENETRABLE, true);
		this.setAssWetness(Wetness.ZERO_DRY);
		this.setAssElasticity(OrificeElasticity.ONE_RIGID.getValue());
		this.setAssPlasticity(OrificePlasticity.THREE_RESILIENT.getValue());
		// Anus modifiers
		
		// Penis:
		this.setPenisVirgin(false);
		this.setPenisGirth(PenisGirth.FOUR_FAT);
		this.setPenisSize(32);
		this.setTesticleSize(TesticleSize.FOUR_HUGE);
		this.setPenisCumStorage(CumProduction.FOUR_LARGE.getMedianValue());
		this.fillCumToMaxStorage();
		
		// Vagina:
		// No vagina
		
		// Feet:
		// Foot shape
	}
	
	@Override
	public void equipClothing(List<EquipClothingSetting> settings) {
		this.unequipAllClothingIntoVoid(true, true);
		
		this.addTattoo(InventorySlot.WRIST, new Tattoo(TattooType.getTattooTypeFromId("innoxia_gang_rat_skull"), Colour.CLOTHING_WHITE, Colour.CLOTHING_WHITE, Colour.CLOTHING_WHITE, false, null, null));
		
		this.setScar(InventorySlot.LEG, new Scar(ScarType.CLAW_MARKS, true));

		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.GROIN_CROTCHLESS_BRIEFS, Colour.CLOTHING_BLACK, false), true, this);
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing("innoxia_leg_crotchless_chaps", Colour.CLOTHING_BLACK, false), true, this);
		
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing("innoxia_hand_wraps", Colour.CLOTHING_BLACK, false), true, this);
		
		this.setPiercedNose(true);
		this.equipClothingFromNowhere(AbstractClothingType.generateClothing(ClothingType.PIERCING_NOSE_BASIC_RING, Colour.CLOTHING_GOLD, false), true, this);
	}
	
	@Override
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		
		if(this.getHomeLocationPlace().getPlaceType()==PlaceType.GAMBLING_DEN_PREGNANCY_ROULETTE) {
			if(this.isFeminine()) {
				sb.append("Having convinced Epona to punish Murk in a manner fitting his crimes, the once rat-'boy' is now a rat-'girl'."
						+ " 'Missy', as she's now known, is still responsible for cleaning up the pregnancy roulette stalls, although Epona seems to be a little more lenient towards her now.");
				
			} else {
				sb.append("Having been enslaved as punishment for his crimes of rape and kidnap, Murk has ended up being given to [axel.name] as a form of compensation for the protection money he was made to pay in the past."
						+ " Not at all interested in owning such a depraved creature, [axel.name] was quick to give him to Epona, who, furious at discovering the facts about Murk's past, has put him to hard work cleaning up the pregnancy roulette stalls.");
			}
			
		} else {
			sb.append("Short, chubby, and with a love for openly displaying his disproportionately huge cock, the rat-boy known as Murk is not exactly known for either his looks or modesty."
					+ " Instead, his undesirable reputation throughout the Rat Warrens has been gained from the open knowledge that he's selfish, cowardly, and has a cruel streak bordering on sadism.");

			sb.append("<br/>"
					+ "Although anyone else would have been subjected to relentless bullying for continuously displaying these less-than-admirable qualities,"
						+ " Murk's fellow gang members tolerate him due to the fact that he runs what he calls the 'Milking Room'."
					+ " This aptly-named area is home to several kidnapped humans, who have been transformed so as to provide both a steady supply of milk and a welcome source of sexual release to Vengar's gang members.");
		}
		
		return sb.toString();
	}
	
	public void applyFeminisation() {
		this.clearFetishes();
		this.clearFetishDesires();
		
		this.addFetish(Fetish.FETISH_SUBMISSIVE);
		this.addFetish(Fetish.FETISH_MASOCHIST);
		this.addFetish(Fetish.FETISH_EXHIBITIONIST);
		
		this.setFetishDesire(Fetish.FETISH_CUM_ADDICT, FetishDesire.THREE_LIKE);
		this.setFetishDesire(Fetish.FETISH_VAGINAL_RECEIVING, FetishDesire.THREE_LIKE);
		this.setFetishDesire(Fetish.FETISH_ANAL_RECEIVING, FetishDesire.THREE_LIKE);
		this.setFetishDesire(Fetish.FETISH_PREGNANCY, FetishDesire.THREE_LIKE);
		this.setFetishDesire(Fetish.FETISH_DOMINANT, FetishDesire.ZERO_HATE);
		this.setFetishDesire(Fetish.FETISH_SADIST, FetishDesire.ZERO_HATE);
		
		// Body:
		// Core:
		this.setHeight(146);
		this.setFemininity(75);
		this.setMuscle(Muscle.ZERO_SOFT.getMedianValue());
		this.setBodySize(BodySize.TWO_AVERAGE.getMedianValue());
		
		// Coverings:
		this.setSkinCovering(new Covering(BodyCoveringType.EYE_RAT, Colour.EYE_YELLOW), true);
		this.setSkinCovering(new Covering(BodyCoveringType.RAT_FUR, Colour.COVERING_BLACK), true);
		this.setSkinCovering(new Covering(BodyCoveringType.RAT_SKIN, Colour.SKIN_PINK_LIGHT), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, Colour.SKIN_EBONY), true);
		this.setSkinCovering(new Covering(BodyCoveringType.PENIS, Colour.SKIN_EBONY), false);
		this.setSkinCovering(new Covering(BodyCoveringType.VAGINA, Colour.SKIN_EBONY), false);
		this.setHairCovering(new Covering(BodyCoveringType.HAIR_RAT_FUR, Colour.COVERING_BLACK), false);
		this.setHairLength(HairLength.THREE_SHOULDER_LENGTH);
		this.setHairStyle(HairStyle.LOOSE);

		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_RAT_FUR, Colour.COVERING_BLACK), false);
		this.setUnderarmHair(BodyHair.ZERO_NONE);
		this.setAssHair(BodyHair.FOUR_NATURAL);
		this.setPubicHair(BodyHair.FOUR_NATURAL);
		this.setFacialHair(BodyHair.ZERO_NONE);

		// Face:
		this.setLipSize(LipSize.TWO_FULL);
		this.setFaceCapacity(Capacity.ZERO_IMPENETRABLE, true);
		this.setTongueLength(TongueLength.ZERO_NORMAL.getMedianValue());
		
		// Chest:
		this.setBreastSize(CupSize.DD.getMeasurement());
		this.setBreastShape(BreastShape.POINTY);
		this.setNippleSize(NippleSize.THREE_LARGE);
		this.setAreolaeSize(AreolaeSize.THREE_LARGE);
		
		// Ass:
		this.setAssSize(AssSize.FOUR_LARGE);
		this.setHipSize(HipSize.FOUR_WOMANLY);
		this.setAssCapacity(Capacity.ZERO_IMPENETRABLE, true);
		this.setAssWetness(Wetness.ONE_SLIGHTLY_MOIST);
		this.setAssElasticity(OrificeElasticity.ONE_RIGID.getValue());
		this.setAssPlasticity(OrificePlasticity.FIVE_YIELDING.getValue());
		// Anus modifiers
		
		// Penis:
		this.setPenisType(PenisType.NONE);
		
		// Vagina:
		this.setVaginaClitorisSize(ClitorisSize.ZERO_AVERAGE);
		this.setVaginaLabiaSize(LabiaSize.THREE_LARGE);
		this.setVaginaSquirter(true);
		this.setVaginaCapacity(Capacity.ONE_EXTREMELY_TIGHT, true);
		this.setVaginaWetness(Wetness.FOUR_SLIMY);
		this.setVaginaElasticity(OrificeElasticity.THREE_FLEXIBLE.getValue());
		this.setVaginaPlasticity(OrificePlasticity.FIVE_YIELDING.getValue());
		
		// Feet:
		// Foot shape
	}
	
	@Override
	public boolean isUnique() {
		return true;
	}
	
	@Override
	public void changeFurryLevel(){
	}
	
	@Override
	public DialogueNode getEncounterDialogue() {
		return null;
	}

	@Override
	public void turnUpdate() {
	}

	@Override
	public boolean isAbleToBeImpregnated(){
		return true;
	}
	
	// Combat:
	
	@Override
	public int getEscapeChance() {
		return 0;
	}
	
	@Override
	public Response endCombat(boolean applyEffects, boolean victory) {
		if(victory) {
			return new Response("", "", RatWarrensCaptiveDialogue.STOCKS_ESCAPE_FIGHT_VICTORY);
			
		} else {
			return new Response("", "", RatWarrensCaptiveDialogue.STOCKS_ESCAPE_FIGHT_DEFEAT);
		}
	}
}