package org.swrlapi.drools.converters;

import org.semanticweb.owlapi.model.OWLIndividual;
import org.swrlapi.converters.TargetRuleEngineOWLIndividualConverter;
import org.swrlapi.core.OWLNamedObjectResolver;
import org.swrlapi.exceptions.TargetRuleEngineException;

/**
 * Converts an OWL individual to its DRL representation for use in a Drools rule.
 */
public class DroolsOWLIndividual2DRLConverter implements TargetRuleEngineOWLIndividualConverter<String>
{
	private final OWLNamedObjectResolver resolver;

	public DroolsOWLIndividual2DRLConverter(OWLNamedObjectResolver resolver)
	{
		this.resolver = resolver;
	}

	@Override
	public String convert(OWLIndividual individual) throws TargetRuleEngineException
	{
		if (individual.isNamed()) {
			return resolver.iri2PrefixedName(individual.asOWLNamedIndividual().getIRI());
		} else
			return individual.asOWLAnonymousIndividual().getID().getID();
	}
}