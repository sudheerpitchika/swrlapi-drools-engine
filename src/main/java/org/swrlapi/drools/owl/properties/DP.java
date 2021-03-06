package org.swrlapi.drools.owl.properties;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.swrlapi.builtins.arguments.SWRLBuiltInArgument;
import org.swrlapi.drools.extractors.DroolsOWLEntityExtractor;
import org.swrlapi.drools.extractors.DroolsSWRLBuiltInArgumentExtractor;
import org.swrlapi.drools.owl.core.OE;
import org.swrlapi.drools.swrl.BA;
import org.swrlapi.exceptions.TargetSWRLRuleEngineException;
import org.swrlapi.exceptions.TargetSWRLRuleEngineInternalException;

/**
 * This class represents an OWL data property in Drools.
 *
 * @see org.semanticweb.owlapi.model.OWLDataProperty
 */
public class DP extends OE implements P, DPE
{
	private static final long serialVersionUID = 1L;

	public DP(String propertyName)
	{
		super(propertyName);
	}

	/**
	 * We have no way of anticipating the return types of built-ins in rules so we need to perform a runtime check.
	 */
	public DP(BA ba)
	{
		super("<InProcess>");

		if (ba instanceof DP) {
			DP p = (DP)ba;
			setId(p.getName());
		} else
			throw new TargetSWRLRuleEngineInternalException("expecting OWL data property from bound built-in argument, got "
					+ ba.getClass().getCanonicalName());
	}

	@Override
	public OWLDataProperty extract(DroolsOWLEntityExtractor extractor) throws TargetSWRLRuleEngineException
	{
		return extractor.extract(this);
	}

	@Override
	public SWRLBuiltInArgument extract(DroolsSWRLBuiltInArgumentExtractor extractor) throws TargetSWRLRuleEngineException
	{
		return extractor.extract(this);
	}

	@Override
	public String toString()
	{
		return super.toString();
	}

	public static DP getOWLTopDataProperty()
	{
		return new DP(OWLRDFVocabulary.OWL_TOP_DATA_PROPERTY.getShortForm());
	}

	public static DP getOWLBottomDataProperty()
	{
		return new DP(OWLRDFVocabulary.OWL_BOTTOM_DATA_PROPERTY.getShortForm());
	}
}
