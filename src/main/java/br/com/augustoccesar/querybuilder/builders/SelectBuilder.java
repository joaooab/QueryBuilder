package br.com.augustoccesar.querybuilder.builders;

import br.com.augustoccesar.querybuilder.query.Comparison;
import br.com.augustoccesar.querybuilder.query.Join;
import br.com.augustoccesar.querybuilder.query.conditions.ConditionSignature;
import br.com.augustoccesar.querybuilder.query.trackers.ConditionsTracker;
import br.com.augustoccesar.querybuilder.query.trackers.FromTracker;
import br.com.augustoccesar.querybuilder.query.trackers.JoinTracker;
import br.com.augustoccesar.querybuilder.query.trackers.SelectTracker;

/**
 * Created by augustoccesar on 6/13/16.
 */
public class SelectBuilder implements Buildable {
    /**
     * Attributes
     */
    private String alias;

    private SelectTracker selectTracker = new SelectTracker();
    private FromTracker fromTracker = new FromTracker();
    private JoinTracker joinTracker = new JoinTracker();
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
        this.joinTracker.addJoin(join);
        return this;
    }

    public SelectBuilder joins(Join... joins) {
        this.joinTracker.addJoins(joins);
        return this;
    }

    public SelectBuilder innerJoin(String markedTable, String markedLeftOn, String markedRightOn) {
        this.joinTracker.addJoin(new Join(Join.INNER, markedTable, markedLeftOn, markedRightOn));
        return this;
    }

    public SelectBuilder leftJoin(String markedTable, String markedLeftOn, String markedRightOn) {
        this.joinTracker.addJoin(new Join(Join.LEFT, markedTable, markedLeftOn, markedRightOn));
        return this;
    }

    public SelectBuilder rightJoin(String markedTable, String markedLeftOn, String markedRightOn) {
        this.joinTracker.addJoin(new Join(Join.RIGHT, markedTable, markedLeftOn, markedRightOn));
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
