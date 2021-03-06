package org.swrlapi.drools.extractors;

import org.swrlapi.bridge.SWRLRuleEngineBridge;
import org.swrlapi.bridge.extractors.TargetRuleEngineExtractorBase;

/**
 * Base class providing methods used by all Drools extractors.
 */
public class DroolsExtractorBase extends TargetRuleEngineExtractorBase
{
	private final DroolsOWLLiteralExtractor literalExtractor;
	private final DroolsOWLEntityExtractor entityExtractor;
	private final DroolsOWLIndividualExtractor individualExtractor;
	private final DroolsSWRLVariableExtractor variableExtractor;

	public DroolsExtractorBase(SWRLRuleEngineBridge bridge)
	{
		super(bridge);

		this.literalExtractor = new DroolsOWLLiteralExtractor(bridge);
		this.entityExtractor = new DefaultDroolsOWLEntityExtractor(bridge);
		this.individualExtractor = new DefaultDroolsOWLIndividualExtractor(bridge);
		this.variableExtractor = new DroolsSWRLVariableExtractor(bridge);
	}

	protected DroolsOWLLiteralExtractor getDroolsOWLLiteralExtractor()
	{
		return this.literalExtractor;
	}

	protected DroolsOWLEntityExtractor getDroolsOWLEntityExtractor()
	{
		return this.entityExtractor;
	}

	protected DroolsOWLIndividualExtractor getDroolsOWLIndividualExtractor()
	{
		return this.individualExtractor;
	}

	protected DroolsSWRLVariableExtractor getDroolsSWRLVariableExtractor()
	{
		return this.variableExtractor;
	}
}
