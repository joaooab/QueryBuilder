package br.com.augustoccesar.querybuilder.builders;

import br.com.augustoccesar.querybuilder.query.Comparison;
import br.com.augustoccesar.querybuilder.query.Join;
import br.com.augustoccesar.querybuilder.query.conditions.ConditionSignature;
import br.com.augustoccesar.querybuilder.query.trackers.ConditionsTracker;
import br.com.augustoccesar.querybuilder.query.trackers.FromTracker;
import br.com.augustoccesar.querybuilder.query.trackers.SelectTracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by augustoccesar on 6/13/16.
 */
public class SelectBuilder implements Buildable {
    /**
     * Attributes
     */
    private String alias;
    private List<Join> joins;

    private SelectTracker selectTracker = new SelectTracker();
    private FromTracker fromTracker = new FromTracker();
    private ConditionsTracker conditionsTracker = new ConditionsTracker();

    /**
     * Constructors
     */
    public SelectBuilder() {
    }

    public SelectBuilder(String alias) {
        this.alias(alias);
    }

    public SelectBuilder alias(String alias) {
        this.alias = alias;
        return this;
    }

    public SelectBuilder select(Object... fields) {
        this.selectTracker.addSelect(fields);
        return this;
    }

    public SelectBuilder from(String... fromTables) {
        this.fromTracker.addMarkedTables(fromTables);
        return this;
    }

    public SelectBuilder join(Join join) {
        if (this.joins == null)
            this.joins = new ArrayList<>();

        this.joins.add(join);
        return this;
    }

    public SelectBuilder joins(Join... joins) {
        if (this.joins == null)
            this.joins = new ArrayList<>();

        Collections.addAll(this.joins, joins);
        return this;
    }

    public SelectBuilder where(String columnMarkdown, Comparison comparison, Object value) {
        conditionsTracker.addCondition(columnMarkdown, comparison, value);
        return this;
    }

    public SelectBuilder where(ConditionSignature... conditions) {
        conditionsTracker.addConditions(conditions);
        return this;
    }

    @Override
    public String build() {
        if(this.alias != null){
            // TODO wrap around parenthesis
        }
        return null;
    }
}
