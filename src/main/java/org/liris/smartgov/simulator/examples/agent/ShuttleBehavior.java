package org.liris.smartgov.simulator.examples.agent;

import org.liris.smartgov.simulator.core.agent.moving.MovingAgentBody;
import org.liris.smartgov.simulator.core.agent.moving.behavior.MoverAction;
import org.liris.smartgov.simulator.core.agent.moving.behavior.MovingBehavior;
import org.liris.smartgov.simulator.core.environment.SmartGovContext;
import org.liris.smartgov.simulator.core.environment.graph.Node;

public class ShuttleBehavior extends MovingBehavior {
	
	public ShuttleBehavior(MovingAgentBody agentBody, Node node1, Node node2, SmartGovContext context) {
		super(agentBody, node1, node2, context);
		agentBody.addOnDestinationReachedListener((event) ->
			// On destination reached, invert origin and destination to do the return trip
			// The agentBody's plan will be updated accordingly to find the shortest path
			// from the new origin to the new destination.

			refresh(getDestination(), getOrigin())
		);
	}

	@Override
	public MoverAction provideAction() {
		return MoverAction.MOVE();
	}
}
