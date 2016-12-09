package com.ofbizian.semat.fixture.scenarios;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.ofbizian.semat.dom.domain.AlphaType;
import com.ofbizian.semat.dom.domain.Item;
import com.ofbizian.semat.dom.domain.ProjectRepository;
import com.ofbizian.semat.dom.domain.State;
import com.ofbizian.semat.fixture.dom.ItemCreate;
import com.ofbizian.semat.fixture.dom.StateCreate;

public class SematFixture extends AbstractFixtureScript {

    public SematFixture(String userName, List<String> roles) {
        setUserName(userName);
        setRoles(roles);
    }

    public SematFixture() {
        withDiscoverability(Discoverability.NON_DISCOVERABLE);
    }

    private Set<State> states = Sets.newLinkedHashSet();
    private Set<Item> items = Sets.newLinkedHashSet();

    @Override
    protected void doExecute(ExecutionContext ec) {
        createWayOfWorkingStates(ec);
        createTeamStates(ec);
        createWorkStates(ec);
        createOpportunityStates(ec);
        createStakeholdersStates(ec);
        createRequirementsStates(ec);
        createSoftwareSystemStates(ec);
    }

    private void createWayOfWorkingStates(ExecutionContext ec) {
        State estabilished = createState(ec, AlphaType.WAY_OF_WORKING, "Principles Established", "The principles, and constraints, that shape the way-of-working are established.");
        State foundationEstabilished = createState(ec, AlphaType.WAY_OF_WORKING, "Foundation Established", "The key practices, and tools, that form the foundation of the way of working are selected and ready for use.");
        State inUse = createState(ec, AlphaType.WAY_OF_WORKING, "In Use", "Some members of the team are using, and adapting, the way-of- working.");
        State inPlace = createState(ec, AlphaType.WAY_OF_WORKING, "In Place", "All team members are using the way of working to accomplish their work.");
        State working = createState(ec, AlphaType.WAY_OF_WORKING, "Working well", "The team's way of working is working well for the team.");
        State retired = createState(ec, AlphaType.WAY_OF_WORKING, "Retired", "The way of working is no longer in use by the team.");

        createItem(ec, estabilished, "Principles and constraints are committed to by the team.");
        createItem(ec, estabilished, "Principles and constraints are agreed to by the stakeholders.");
        createItem(ec, estabilished, "The tool needs of the work and its stakeholders are agreed.");
        createItem(ec, estabilished, "A recommendation for the approach to be taken is available.");
        createItem(ec, estabilished, "The context within which the team will operate is understood.");
        createItem(ec, estabilished, "The constraints that apply to the selection, acquisition, and use of practices and tools are known.");

        createItem(ec, foundationEstabilished, "The key practices and tools that form the foundation of the way-of-working are selected.");
        createItem(ec, foundationEstabilished, "Enough practices for work to start are agreed to by the team.");
        createItem(ec, foundationEstabilished, "All non-negotiable practices and tools have been identified.");
        createItem(ec, foundationEstabilished, "The gaps that exist between the practices and tools that are needed and the practices and tools that are available have been analyzed and understood.");
        createItem(ec, foundationEstabilished, "The capability gaps that exist between what is needed to execute the desired way of working and the capability levels of the team have been analyzed and understood.");
        createItem(ec, foundationEstabilished, "The selected practices and tools have been integrated to form a usable way-of-working.");

        createItem(ec, inUse, "The practices and tools are being used to do real work.");
        createItem(ec, inUse, "The use of the practices and tools selected are regularly inspected.");
        createItem(ec, inUse, "The practices and tools are being adapted to the team’s context.");
        createItem(ec, inUse, "The use of the practices and tools is supported by the team.");
        createItem(ec, inUse, "Procedures are in place to handle feedback on the team’s way of working.");
        createItem(ec, inUse, "The practices and tools support team communication and collaboration.");

        createItem(ec, inPlace, "The practices and tools are being used by the whole team to perform their work.");
        createItem(ec, inPlace, "All team members have access to the practices and tools required to do their work.");
        createItem(ec, inPlace, "The whole team is involved in the inspection and adaptation of the way-of-working.");

        createItem(ec, working, "Team members are making progress as planned by using and adapting the way-of- working to suit their current context.");
        createItem(ec, working, "The team naturally applies the practices without thinking about them");
        createItem(ec, working, "The tools naturally support the way that the team works.");
        createItem(ec, working, "The team continually tunes their use of the practices and tools.");

        createItem(ec, retired, "The team's way of working is no longer being used.");
        createItem(ec, retired, "Lessons learned are shared for future use.");
    }

    private void createTeamStates(ExecutionContext ec) {
        State seeded = createState(ec, AlphaType.TEAM, "Seeded", "The team’s mission is clear and the know-how needed to grow the team is in place.");
        State formed = createState(ec, AlphaType.TEAM, "Formed", "The team has been populated with enough committed people to start the mission.");
        State collaborating = createState(ec, AlphaType.TEAM, "Collaborating", "The team members are working together as one unit.");
        State performing = createState(ec, AlphaType.TEAM, "Performing", "The team is working effectively and efficiently.");
        State adjourned = createState(ec, AlphaType.TEAM, "Adjourned", "The team is no longer accountable for carrying out its mission.");

        createItem(ec, seeded, "The team mission has been defined in terms of the opportunities and outcomes.");
        createItem(ec, seeded, "Constraints on the team's operation are known.");
        createItem(ec, seeded, "Mechanisms to grow the team are in place.");
        createItem(ec, seeded, "The composition of the team is defined.");
        createItem(ec, seeded, "Any constraints on where and how the work is carried out are defined.");
        createItem(ec, seeded, "The team's responsibilities are outlined.");
        createItem(ec, seeded, "The level of team commitment is clear.");
        createItem(ec, seeded, "Required competencies are identified.");
        createItem(ec, seeded, "The team size is determined.");
        createItem(ec, seeded, "Governance rules are defined.");
        createItem(ec, seeded, "Leadership model is selected.");

        createItem(ec, formed, "Individual responsibilities are understood.");
        createItem(ec, formed, "Enough team members have been recruited to enable the work to progress.");
        createItem(ec, formed, "Every team member understands how the team is organized and what their individual role is.");
        createItem(ec, formed, "All team members understand how to perform their work.");
        createItem(ec, formed, "The team members have met (perhaps virtually) and are beginning to get to know each other.");
        createItem(ec, formed, "The team members understand their responsibilities and how they align with their competencies.");
        createItem(ec, formed, "Team members are accepting work.");
        createItem(ec, formed, "Any external collaborators (organizations, teams and individuals) are identified.");
        createItem(ec, formed, "Team communication mechanisms have been defined.");
        createItem(ec, formed, "Each team member commits to working on the team as defined.");

        createItem(ec, collaborating, "The team is working as one cohesive unit.");
        createItem(ec, collaborating, "Communication within the team is open and honest.");
        createItem(ec, collaborating, "The team is focused on achieving the team mission.");
        createItem(ec, collaborating, "The team members know each other.");

        createItem(ec, performing, "The team consistently meets its commitments.");
        createItem(ec, performing, "The team continuously adapts to the changing context.");
        createItem(ec, performing, "The team identifies and addresses problems without outside help.");
        createItem(ec, performing, "Effective progress is being achieved with minimal avoidable backtracking and reworking.");
        createItem(ec, performing, "Wasted work, and the potential for wasted work are continuously eliminated.");

        createItem(ec, adjourned, "The team responsibilities have been handed over or fulfilled.");
        createItem(ec, adjourned, "The team members are available for assignment to other teams.");
        createItem(ec, adjourned, "No further effort is being put in by the team to complete the mission.");
    }

    private void createWorkStates(ExecutionContext ec) {
        State initiated = createState(ec, AlphaType.WORK, "Initiated", "The work has been requested.");
        State prepared = createState(ec, AlphaType.WORK, "Prepared", "All pre-conditions for starting the work have been met.");
        State started = createState(ec, AlphaType.WORK, "Started", "The work is proceeding.");
        State controlled = createState(ec, AlphaType.WORK, "Under Control", "The work is going well, risks are under control, and productivity levels are sufficient to achieve a satisfactory result.");
        State concluded = createState(ec, AlphaType.WORK, "Concluded", "The work to produce the results has been concluded.");
        State closed = createState(ec, AlphaType.WORK, "Closed", "All remaining housekeeping tasks have been completed and the work has been officially closed.");

        createItem(ec, initiated, "The result required of the work being initiated is clear.");
        createItem(ec, initiated, "Any constraints on the work’s performance are clearly identified.");
        createItem(ec, initiated, "The stakeholders that will fund the work are known.");
        createItem(ec, initiated, "The initiator of the work is clearly identified.");
        createItem(ec, initiated, "The stakeholders that will accept the results are known.");
        createItem(ec, initiated, "The source of funding is clear.");
        createItem(ec, initiated, "The priority of the work is clear.");

        createItem(ec, prepared, "Commitment is made.");
        createItem(ec, prepared, "Cost and effort of the work are estimated.");
        createItem(ec, prepared, "Resource availability is understood.");
        createItem(ec, prepared, "Governance policies and procedures are clear.");
        createItem(ec, prepared, "Risk exposure is understood.");
        createItem(ec, prepared, "Acceptance criteria are defined and agreed with client.");
        createItem(ec, prepared, "The work is broken down sufficiently for productive work to start.");
        createItem(ec, prepared, "Tasks have been identified and prioritized by the team and stakeholders.");
        createItem(ec, prepared, "A credible plan is in place.");
        createItem(ec, prepared, "Funding to start the work is in place.");
        createItem(ec, prepared, "The team or at least some of the team members are ready to start the work.");
        createItem(ec, prepared, "Integration and delivery points are defined.");

        createItem(ec, started, "Development work has been started.");
        createItem(ec, started, "Work progress is monitored.");
        createItem(ec, started, "The work is being broken down into actionable work items with clear definitions of done.");
        createItem(ec, started, "Team members are accepting and progressing tasks.");

        createItem(ec, controlled, "Tasks are being completed.");
        createItem(ec, controlled, "Unplanned work is under control.");
        createItem(ec, controlled, "Risks are under control as the impact if they occur and the likelihood of them occurring have been reduced to acceptable levels.");
        createItem(ec, controlled, "Estimates are revised to reflect the team’s performance.");
        createItem(ec, controlled, "Measures are available to show progress and velocity.");
        createItem(ec, controlled, "Re-work is under control.");
        createItem(ec, controlled, "Tasks are consistently completed on time and within their estimates.");

        createItem(ec, concluded, "All outstanding tasks are administrative housekeeping or related to preparing the next piece of work.");
        createItem(ec, concluded, "Work results have been achieved.");
        createItem(ec, concluded, "The stakeholder(s) has accepted the resulting software system.");

        createItem(ec, closed, "Lessons learned have been itemized, recorded and discussed.");
        createItem(ec, closed, "Metrics have been made available.");
        createItem(ec, closed, "Everything has been archived.");
        createItem(ec, closed, "The budget has been reconciled and closed.");
        createItem(ec, closed, "The team has been released.");
        createItem(ec, closed, "There are no outstanding, uncompleted tasks.");
    }

    private void createOpportunityStates(ExecutionContext ec) {
        State identified = createState(ec, AlphaType.OPPORTUNITY, "Identified", "A commercial, social, or business opportunity has been identified that could be addressed by a software-based solution.");
        State solutionNeeded = createState(ec, AlphaType.OPPORTUNITY, "Solution Needed", "The need for a software-based solution has been confirmed.");
        State valueEstabilished = createState(ec, AlphaType.OPPORTUNITY, "Value Established", "The value of a successful solution has been established.");
        State viable = createState(ec, AlphaType.OPPORTUNITY, "Viable", "It is agreed that a solution can be produced quickly and cheaply enough to successfully address the opportunity.");
        State addressed = createState(ec, AlphaType.OPPORTUNITY, "Addressed", "A solution has been produced that demonstrably addresses the opportunity.");
        State benefitAccured = createState(ec, AlphaType.OPPORTUNITY, "Benefit Accrued", "The operational use or sale of the solution is creating tangible benefits.");

        createItem(ec, identified, "An idea for a way of improving current ways of working, increasing market share, or applying a new or innovative software system has been identified.");
        createItem(ec, identified, "At least one of the stakeholders wishes to make an investment in better understanding the opportunity and the value associated with addressing it.");
        createItem(ec, identified, "The other stakeholders who share the opportunity have been identified.");

        createItem(ec, solutionNeeded, "The stakeholders in the opportunity and the proposed solution have been identified.");
        createItem(ec, solutionNeeded, "The stakeholders' needs that generate the opportunity have been established.");
        createItem(ec, solutionNeeded, "Any underlying problems and their root causes have been identified.");
        createItem(ec, solutionNeeded, "It has been confirmed that a software-based solution is needed.");
        createItem(ec, solutionNeeded, "At least one software-based solution has been proposed.");

        createItem(ec, valueEstabilished, "The value of addressing the opportunity has been quantified either in absolute terms or in returns or savings per time period (e.g., per annum).");
        createItem(ec, valueEstabilished, "The impact of the solution on the stakeholders is understood.");
        createItem(ec, valueEstabilished, "The value that the software system offers to the stakeholders that fund and use the software system is understood.");
        createItem(ec, valueEstabilished, "The success criteria by which the deployment of the software system is to be judged are clear.");
        createItem(ec, valueEstabilished, "The desired outcomes required of the solution are clear and quantified.");

        createItem(ec, viable, "A solution has been outlined.");
        createItem(ec, viable, "The indications are that the solution can be developed and deployed within constraints.");
        createItem(ec, viable, "The risks associated with the solution are acceptable and manageable.");
        createItem(ec, viable, "The indicative (ball-park) costs of the solution are less than the anticipated value of the opportunity.");
        createItem(ec, viable, "The reasons for the development of a software-based solution are understood by all members of the team.");
        createItem(ec, viable, "It is clear that the pursuit of the opportunity is viable.");

        createItem(ec, addressed, "A usable system that demonstrably addresses the opportunity is available.");
        createItem(ec, addressed, "The stakeholders agree that the available solution is worth deploying.");
        createItem(ec, addressed, "The stakeholders are satisfied that the solution produced addresses the opportunity.");

        createItem(ec, benefitAccured, "The solution has started to accrue benefits for the stakeholders.");
        createItem(ec, benefitAccured, "The return-on-investment profile is at least as good as anticipated.");
    }

    private void createStakeholdersStates(ExecutionContext ec) {
        State recognized = createState(ec, AlphaType.STAKEHOLDERS, "Recognized", "Stakeholders have been identified.");
        State represented = createState(ec, AlphaType.STAKEHOLDERS, "Represented", "The mechanisms for involving the AlphaType.STAKEHOLDERS are agreed and the stakeholder representatives have been appointed.");
        State involved = createState(ec, AlphaType.STAKEHOLDERS, "Involved", "The stakeholder representatives are actively involved in the work and fulfilling their responsibilities.");
        State inAgreement = createState(ec, AlphaType.STAKEHOLDERS, "In Agreement", "The stakeholder representatives are in agreement.");
        State inDeployment = createState(ec, AlphaType.STAKEHOLDERS, "Satisfied for Deployment", "The minimal expectations of the stakeholder representatives have been achieved.");
        State satisfied = createState(ec, AlphaType.STAKEHOLDERS, "Satisfied in Use", "The system has met or exceeds the minimal stakeholder expectations.");

        createItem(ec, recognized, "All the different groups of stakeholders that are, or will be, affected by the development and operation of the software system are identified.");
        createItem(ec, recognized, "There is agreement on the stakeholder groups to be represented. At a minimum, the stakeholders groups that fund, use, support, and maintain the system have been considered.");
        createItem(ec, recognized, "The responsibilities of the stakeholder representatives have been defined.");

        createItem(ec, represented, "The stakeholder representatives have agreed to take on their responsibilities.");
        createItem(ec, represented, "The stakeholder representatives are authorized to carry out their responsibilities.");
        createItem(ec, represented, "The collaboration approach among the stakeholder representatives has been agreed.");
        createItem(ec, represented, "The stakeholder representatives support and respect the team's way of working.");

        createItem(ec, involved, "The stakeholder representatives assist the team in accordance with their responsibilities.");
        createItem(ec, involved, "The stakeholder representatives provide feedback and take part in decision making in a timely manner.");
        createItem(ec, involved, "The stakeholder representatives provide feedback and take part in decision making in a timely manner.");

        createItem(ec, inAgreement, "The stakeholder representatives have agreed upon their minimal expectations for the next deployment of the new system.");
        createItem(ec, inAgreement, "The stakeholder representatives are happy with their involvement in the work.");
        createItem(ec, inAgreement, "The stakeholder representatives agree that their input is valued by the team and treated with respect.");
        createItem(ec, inAgreement, "The team members agree that their input is valued by the stakeholder representatives and treated with respect.");
        createItem(ec, inAgreement, "The stakeholder representatives agree with how their different priorities and perspectives are being balanced to provide a clear direction for the team.");

        createItem(ec, inDeployment, "The stakeholder representatives provide feedback on the system from their stakeholder group perspective.");
        createItem(ec, inDeployment, "The stakeholder representatives confirm that they agree that the system is ready for deployment.");

        createItem(ec, satisfied, "Stakeholders are using the new system and providing feedback on their experiences.");
        createItem(ec, satisfied, "The stakeholders confirm that the new system meets their expectations.");
    }

    private void createSoftwareSystemStates(ExecutionContext ec) {
        State selected = createState(ec, AlphaType.SOFTWARE_SYSTEM, "Architecture Selected", "An architecture has been selected that addresses the key technical risks and any applicable organizational constraints.");
        State demonstrable = createState(ec, AlphaType.SOFTWARE_SYSTEM, "Demonstrable", "An executable version of the system is available that demonstrates the architecture is fit for purpose and supports testing.");
        State usable = createState(ec, AlphaType.SOFTWARE_SYSTEM, "Usable", "The system is usable and demonstrates all of the quality characteristics of an operational system.");
        State ready = createState(ec, AlphaType.SOFTWARE_SYSTEM, "Ready", "The system (as a whole) has been accepted for deployment in a live environment.");
        State operational = createState(ec, AlphaType.SOFTWARE_SYSTEM, "Operational", "The system is in use in an operational environment.");
        State systemRetired = createState(ec, AlphaType.SOFTWARE_SYSTEM, "Retired", "The system is no longer supported.");

        createItem(ec, selected, "The criteria to be used when selecting the architecture have been agreed on.");
        createItem(ec, selected, "Hardware platforms have been identified.");
        createItem(ec, selected, "Programming languages and technologies to be used have been selected.");
        createItem(ec, selected, "System boundary is known.");
        createItem(ec, selected, "Significant decisions about the organization of the system have been made.");
        createItem(ec, selected, "Buy, build, and reuse decisions have been made.");
        createItem(ec, selected, "Key technical risks agreed to.");

        createItem(ec, demonstrable, "Key architectural characteristics have been demonstrated.");
        createItem(ec, demonstrable, "The system can be exercised and its performance can be measured.");
        createItem(ec, demonstrable, "Critical hardware configurations have been demonstrated.");
        createItem(ec, demonstrable, "Critical interfaces have been demonstrated.");
        createItem(ec, demonstrable, "The integration with other existing systems has been demonstrated.");

        createItem(ec, usable, "The system can be operated by stakeholders who use it.");
        createItem(ec, usable, "The functionality provided by the system has been tested.");
        createItem(ec, usable, "The performance of the system is acceptable to the stakeholders.");
        createItem(ec, usable, "Defect levels are acceptable to the stakeholders.");
        createItem(ec, usable, "The system is fully documented.");
        createItem(ec, usable, "Release content is known.");
        createItem(ec, usable, "The added value provided by the system is clear.");

        createItem(ec, ready, "Installation and other user documentation are available.");
        createItem(ec, ready, "The stakeholder representatives accept the system as fit-for-purpose.");
        createItem(ec, ready, "The stakeholder representatives want to make the system operational.");
        createItem(ec, ready, "Operational support is in place.");

        createItem(ec, operational, "The system has been made available to the stakeholders intended to use it.");
        createItem(ec, operational, "At least one example of the system is fully operational.");
        createItem(ec, operational, "The system is fully supported to the agreed service levels.");

        createItem(ec, systemRetired, "The system has been replaced or discontinued.");
        createItem(ec, systemRetired, "The system is no longer supported.");
        createItem(ec, systemRetired, "There are no “official” stakeholders who still use the system.");
        createItem(ec, systemRetired, "Updates to the system will no longer be produced.");
    }

    private void createRequirementsStates(ExecutionContext ec) {
        State conceived = createState(ec, AlphaType.REQUIREMENTS, "Conceived", "The need for a new system has been agreed.");
        State bounded = createState(ec, AlphaType.REQUIREMENTS, "Bounded", "The purpose and extent of the new system are clear.");
        State coherent = createState(ec, AlphaType.REQUIREMENTS, "Coherent", "The requirements provide a consistent description of the essential");
        State acceptable = createState(ec, AlphaType.REQUIREMENTS, "Acceptable", "The requirements describe a system that is acceptable to the stakeholders.");
        State requirementsAddressed = createState(ec, AlphaType.REQUIREMENTS, "Addressed", "Enough of the requirements have been addressed to satisfy the need for a new system in a way that is acceptable to the stakeholders.");
        State fulfilled = createState(ec, AlphaType.REQUIREMENTS, "Fulfilled", "The requirements that have been addressed fully satisfy the need for a new system.");

        createItem(ec, conceived, "The initial set of stakeholders agrees that a system is to be produced.");
        createItem(ec, conceived, "The stakeholders that will use the new system are identified.");
        createItem(ec, conceived, "The stakeholders that will fund the initial work on the new system are identified.");
        createItem(ec, conceived, "There is a clear opportunity for the new system to address.");

        createItem(ec, bounded, "The stakeholders involved in developing the new system are identified.");
        createItem(ec, bounded, "The stakeholders agree on the purpose of the new system.");
        createItem(ec, bounded, "It is clear what success is for the new system.");
        createItem(ec, bounded, "The stakeholders have a shared understanding of the extent of the proposed solution.");
        createItem(ec, bounded, "The way the requirements will be described is agreed upon.");
        createItem(ec, bounded, "The mechanisms for managing the requirements are in place.");
        createItem(ec, bounded, "The prioritization scheme is clear.");
        createItem(ec, bounded, "Constraints are identified and considered.");
        createItem(ec, bounded, "Assumptions are clearly stated.");

        createItem(ec, coherent, "The requirements are captured and shared with the team and the stakeholders.");
        createItem(ec, coherent, "The origin of the requirements is clear.");
        createItem(ec, coherent, "The rationale behind the requirements is clear.");
        createItem(ec, coherent, "Conflicting requirements are identified and attended to.");
        createItem(ec, coherent, "The requirements communicate the essential characteristics of the system to be delivered.");
        createItem(ec, coherent, "The most important usage scenarios for the system can be explained.");
        createItem(ec, coherent, "The priority of the requirements is clear.");
        createItem(ec, coherent, "The impact of implementing the requirements is understood.");
        createItem(ec, coherent, "The team understands what has to be delivered and agrees to deliver it.");

        createItem(ec, acceptable, "The stakeholders accept that the requirements describe an acceptable solution.");
        createItem(ec, acceptable, "The rate of change to the agreed requirements is relatively low and under control.");
        createItem(ec, acceptable, "The value provided by implementing the requirements is clear.");
        createItem(ec, acceptable, "The parts of the opportunity satisfied by the requirements are clear.");
        createItem(ec, acceptable, "The requirements are testable.");

        createItem(ec, requirementsAddressed, "Enough of the requirements are addressed for the resulting system to be acceptable to the stakeholders.");
        createItem(ec, requirementsAddressed, "The stakeholders accept the requirements as accurately reflecting what the system does and does not do.");
        createItem(ec, requirementsAddressed, "The set of requirement items implemented provide clear value to the stakeholders.");
        createItem(ec, requirementsAddressed, "The system implementing the requirements is accepted by the stakeholders as worth making operational.");

        createItem(ec, fulfilled, "The stakeholders accept the requirements as accurately capturing what they require to fully satisfy the need for a new system.");
        createItem(ec, fulfilled, "There are no outstanding requirement items preventing the system from being accepted as fully satisfying the requirements.");
        createItem(ec, fulfilled, "The system is accepted by the stakeholders as fully satisfying the requirements.");
    }

    private State createState(ExecutionContext ec, AlphaType alphaType, String name, String description) {
        StateCreate stateCreate = new StateCreate();
        stateCreate.setUserName(userName);
        stateCreate.setAlphaType(alphaType);
        stateCreate.setName(name);
        stateCreate.setDescription(description);

        ec.executeChild(this, stateCreate.getName(), stateCreate);
        states.add(stateCreate.getState());
        return stateCreate.getState();
    }

    private Item createItem(ExecutionContext ec, State state, String description) {
        ItemCreate itemCreate = new ItemCreate();
        itemCreate.setUserName(userName);
        itemCreate.setDescription(description);
        itemCreate.setState(state);

        ec.executeChild(this, itemCreate.getDescription(), itemCreate);
        final Item item = itemCreate.getItem();
//        state.addToItems(item);
        items.add(item);
        return item;
    }

    @javax.inject.Inject
    private ProjectRepository repository;
}
