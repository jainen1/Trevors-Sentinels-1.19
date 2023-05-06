package net.trevorskullcrafter.trevorssentinels.advancement.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.AdvancementEntityPredicateSerializer;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class LensCriterion extends AbstractCriterion<LensCriterion.Conditions> {
    final Identifier id;

    public LensCriterion(Identifier id) { this.id = id; }
    public Identifier getId() { return this.id; }

    protected Conditions conditionsFromJson(JsonObject obj, EntityPredicate.Extended playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        ItemPredicate itemPredicate = ItemPredicate.fromJson(obj.get("item"));
        return new Conditions(this.id, playerPredicate, itemPredicate);
    }

    public static class Conditions extends AbstractCriterionConditions {
        private final ItemPredicate item;

        public Conditions(Identifier id, EntityPredicate.Extended entity, ItemPredicate item) {
            super(id, entity);
            this.item = item;
        }

        public static LensCriterion.Conditions create(ItemPredicate.Builder item) {
            return new LensCriterion.Conditions(Criteria.ITEM_USED_ON_BLOCK.getId(), EntityPredicate.Extended.EMPTY, item.build());
        }

        public JsonObject toJson(AdvancementEntityPredicateSerializer predicateSerializer) {
            JsonObject jsonObject = super.toJson(predicateSerializer);
            jsonObject.add("item", this.item.toJson());
            return jsonObject;
        }
    }
}