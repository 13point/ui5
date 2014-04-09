/**
 * @author Adrian Yao <adrianYao@augmentum.com.cn>
 * @version 1.6
 * @since 2014 Mar 28, 2014
 */
package com.augmentum.ec.core.constant;

/**
 * The Enum Sort.
 */
public enum Sort {

    /** The asc. */
    ASC(" ASC "),
    /** The desc. */
    DESC(" DESC ");

    /** The grammar. */
    private String grammar;

    /**
     * Instantiates a new sort.
     *
     * @param grammar the grammar
     */
    private Sort(final String grammar) {
        this.grammar = grammar;
    }

    /**
     * Gets the grammar.
     *
     * @return the grammar
     */
    public String getGrammar() {
        return grammar;
    }
}
