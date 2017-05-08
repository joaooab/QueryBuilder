package br.com.augustoccesar.querybuilder.query.conditions;

/**
 * Author: augustoccesar
 * Date: 05/05/17
 */
enum ConditionLink {
    AND(" AND "),
    OR(" OR ");

    private String displayName;

    ConditionLink(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
