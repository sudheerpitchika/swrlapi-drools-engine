package org.swrlapi.drools.owl.core;

import java.io.Serializable;

import org.semanticweb.owlapi.vocab.XSDVocabulary;
import org.swrlapi.builtins.arguments.SWRLBuiltInArgument;
import org.swrlapi.drools.extractors.DroolsSWRLBuiltInArgumentExtractor;
import org.swrlapi.drools.swrl.BA;
import org.swrlapi.exceptions.TargetSWRLRuleEngineException;
import org.swrlapi.exceptions.TargetSWRLRuleEngineInternalException;

/**
 * Class representing an OWL literal in Drools
 *
 * @see org.semanticweb.owlapi.model.OWLLiteral
 */
public class L implements OO, BA, Serializable
{
	private static final long serialVersionUID = 1L;

	public final String value;
	public final String datatypeName;

	public L(String value, String datatypeName)
	{
		this.value = value;
		this.datatypeName = datatypeName;
	}

	public L(L l)
	{
		this.value = l.value;
		this.datatypeName = l.datatypeName;
	}

	/**
	 * We have no way of anticipating the return types of built-ins in rules so we need to perform a runtime check.
	 */
	public L(BA ba)
	{
		if (ba instanceof L) {
			L l = (L)ba;
			this.value = l.getValue();
			this.datatypeName = l.getTypeName();
		} else
			throw new TargetSWRLRuleEngineInternalException("expecting OWL literal from bound built-in argument, got "
					+ ba.getClass().getCanonicalName());
	}

	public boolean isInt()
	{
		return this.datatypeName.equals(XSDVocabulary.INT.getPrefixedName());
	}

	public boolean isLong()
	{
		return this.datatypeName.equals(XSDVocabulary.LONG.getPrefixedName());
	}

	public boolean isFloat()
	{
		return this.datatypeName.equals(XSDVocabulary.FLOAT.getPrefixedName());
	}

	public boolean isDouble()
	{
		return this.datatypeName.equals(XSDVocabulary.DOUBLE.getPrefixedName());
	}

	public boolean isShort()
	{
		return this.datatypeName.equals(XSDVocabulary.SHORT.getPrefixedName());
	}

	public boolean isBoolean()
	{
		return this.datatypeName.equals(XSDVocabulary.BOOLEAN.getPrefixedName());
	}

	public boolean isByte()
	{
		return this.datatypeName.equals(XSDVocabulary.BYTE.getPrefixedName());
	}

	public boolean isAnyURI()
	{
		return this.datatypeName.equals(XSDVocabulary.ANY_URI.getPrefixedName());
	}

	public boolean isTime()
	{
		return this.datatypeName.equals(XSDVocabulary.TIME.getPrefixedName());
	}

	public boolean isDate()
	{
		return this.datatypeName.equals(XSDVocabulary.DATE.getPrefixedName());
	}

	public boolean isDateTime()
	{
		return this.datatypeName.equals(XSDVocabulary.DATE_TIME.getPrefixedName());
	}

	public boolean isDuration()
	{
		return this.datatypeName.equals(XSDVocabulary.DURATION.getPrefixedName());
	}

	public boolean isString()
	{
		return this.datatypeName.equals(XSDVocabulary.STRING.getPrefixedName());
	}

	@Override
	public SWRLBuiltInArgument extract(DroolsSWRLBuiltInArgumentExtractor extractor) throws TargetSWRLRuleEngineException
	{
		return extractor.extract(this);
	}

	@Override
	public String toString()
	{
		return "L(\"" + this.value + "\", " + this.datatypeName + ")";
	}

	public String getTypeName()
	{
		return this.datatypeName;
	}

	public String getValue()
	{
		return this.value;
	}

	// We consider literals to be equal if they have the same type name and value.
	// TODO This is a very simpleminded implementation of equals. Think about using the SWRLAPI's OWLLiteralComparator

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		L l = (L)obj;
		return (getTypeName() == l.getTypeName() || (getTypeName() != null && getTypeName().equals(l.getTypeName())))
				&& (getValue() == l.getValue() || (getValue() != null && getValue().equals(l.getValue())));
	}

	@Override
	public int hashCode()
	{
		int hash = 66;

		hash = hash + (null == getTypeName() ? 0 : getTypeName().hashCode());
		hash = hash + (null == getValue() ? 0 : getValue().hashCode());

		return hash;
	}
}
