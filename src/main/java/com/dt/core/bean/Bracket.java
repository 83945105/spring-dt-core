package com.dt.core.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: 括号</p>
 * <p>Description: </p>
 *
 * @author 白超
 * @date 2017年4月17日 下午4:38:19
 * @版本 V 1.0
 */
public final class Bracket {

    protected Bracket bracket;

    protected Bracket bracketExtend;

    public boolean hasBracket() {
        return bracket != null;
    }

    public boolean hasBracketExtend() {
        return bracketExtend != null;
    }

    //and条件集合
    protected List<Bracket> andList;
    //or条件集合
    protected List<Bracket> orList;

    public boolean hasAnd() {
        return andList != null && andList.size() > 0;
    }

    public List<Bracket> getAndList() {
        return andList;
    }

    public boolean hasOr() {
        return orList != null && orList.size() > 0;
    }

    public List<Bracket> getOrList() {
        return orList;
    }

    //每一个括号内可能包含一组条件
    protected List<Criterion> criterionList;

    public boolean hasCriterion() {
        return criterionList != null && criterionList.size() > 0;
    }

    //是否生成左右括号
    public boolean hasGeneratorBracket() {

        if (isBracket()) {//是括号
            return orList != null && orList.size() > 0;
        } else {//是条件
            return criterionList != null && criterionList.size() > 1;
        }

    }

    //是否是括号,不是的话就是条件
    public boolean isBracket() {
        return andList != null || orList != null;
    }

    public List<Criterion> getCriterionList() {
        return criterionList;
    }

    public Bracket() {
        super();
    }

    public Bracket(List<Criterion> criterionList) {
        super();
        this.criterionList = criterionList;
    }

    public Bracket andBracket(Criterion criterion) {
        if (criterion != null) {
            this.bracket = this.bracket == null ? new Bracket() : this.bracket;
            List<Criterion> criterionList = new ArrayList<>();
            criterionList.add(criterion);
            this.bracket.andList = this.bracket.andList == null ? new ArrayList<>() : this.bracket.andList;
            this.bracket.andList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket andBracketExtend(Criterion criterion) {
        if (criterion != null) {
            this.bracketExtend = this.bracketExtend == null ? new Bracket() : this.bracketExtend;
            List<Criterion> criterionList = new ArrayList<>();
            criterionList.add(criterion);
            this.bracketExtend.andList = this.bracketExtend.andList == null ? new ArrayList<>() : this.bracketExtend.andList;
            this.bracketExtend.andList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket andBracket(List<Criterion> criterionList) {
        if (criterionList != null && criterionList.size() > 0) {
            this.bracket = this.bracket == null ? new Bracket() : this.bracket;
            this.bracket.andList = this.bracket.andList == null ? new ArrayList<>() : this.bracket.andList;
            this.bracket.andList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket andBracketExtend(List<Criterion> criterionList) {
        if (criterionList != null && criterionList.size() > 0) {
            this.bracketExtend = this.bracketExtend == null ? new Bracket() : this.bracketExtend;
            this.bracketExtend.andList = this.bracketExtend.andList == null ? new ArrayList<>() : this.bracketExtend.andList;
            this.bracketExtend.andList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket andBracket(Bracket bracket) {
        if (bracket.bracket != null) {
            this.bracket = this.bracket == null ? new Bracket() : this.bracket;
            this.bracket.andList = this.bracket.andList == null ? new ArrayList<>() : this.bracket.andList;
            this.bracket.andList.add(bracket.bracket);
        }
        if (bracket.bracketExtend != null) {
            this.bracketExtend = this.bracketExtend == null ? new Bracket() : this.bracketExtend;
            this.bracketExtend.andList = this.bracketExtend.andList == null ? new ArrayList<>() : this.bracketExtend.andList;
            this.bracketExtend.andList.add(bracket.bracketExtend);
        }
        return this;
    }

    public Bracket orBracket(Criterion criterion) {
        if (criterion != null) {
            this.bracket = this.bracket == null ? new Bracket() : this.bracket;
            List<Criterion> criterionList = new ArrayList<>();
            criterionList.add(criterion);
            this.bracket.orList = this.bracket.orList == null ? new ArrayList<>() : this.bracket.orList;
            this.bracket.orList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket orBracketExtend(Criterion criterion) {
        if (criterion != null) {
            this.bracketExtend = this.bracketExtend == null ? new Bracket() : this.bracketExtend;
            List<Criterion> criterionList = new ArrayList<>();
            criterionList.add(criterion);
            this.bracketExtend.orList = this.bracketExtend.orList == null ? new ArrayList<>() : this.bracketExtend.orList;
            this.bracketExtend.orList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket orBracket(List<Criterion> criterionList) {
        if (criterionList != null && criterionList.size() > 0) {
            this.bracket = this.bracket == null ? new Bracket() : this.bracket;
            this.bracket.orList = this.bracket.orList == null ? new ArrayList<>() : this.bracket.orList;
            this.bracket.orList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket orBracketExtend(List<Criterion> criterionList) {
        if (criterionList != null && criterionList.size() > 0) {
            this.bracketExtend = this.bracketExtend == null ? new Bracket() : this.bracketExtend;
            this.bracketExtend.orList = this.bracketExtend.orList == null ? new ArrayList<>() : this.bracketExtend.orList;
            this.bracketExtend.orList.add(new Bracket(criterionList));
        }
        return this;
    }

    public Bracket orBracket(Bracket bracket) {
        if (bracket.bracket != null) {
            this.bracket = this.bracket == null ? new Bracket() : this.bracket;
            this.bracket.orList = this.bracket.orList == null ? new ArrayList<>() : this.bracket.orList;
            this.bracket.orList.add(bracket.bracket);
        } else if (bracket.bracketExtend != null) {
            this.bracketExtend = this.bracketExtend == null ? new Bracket() : this.bracketExtend;
            this.bracketExtend.orList = this.bracketExtend.orList == null ? new ArrayList<>() : this.bracketExtend.orList;
            this.bracketExtend.orList.add(bracket.bracketExtend);
        }
        return this;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public Bracket getBracketExtend() {
        return bracketExtend;
    }

}
