# Agentspeak(L)
Implementation of agent based programming language, AgentSpeak(L)

[Rao96] provide an operational and proof-theoretic semantics of a language AgentSpeak(L), an abstract language used for describing and programming BDI agents. AgentSpeak(L) can be viewed as an abstraction of an implemented BDI system known as procedural rea- soning system (PRS). AgentSpeak(L) has been extended for practical agent programming and programs can be executed using the Jason platform [BHW07].

<p>Informally, an AgentSpeak(L) agent consists of:</p>

<ul>
  <li>A set of base beliefs, B, (containing the initial beliefs of an agent),</li>
  <li>A set of plans, P, (predefined plan library),
  <li>A set of events, E,</li>
  <li>A set of actions, A,</li>
  <li>An intention set, I,</li>
  <li>Three selection functions:</li>
  <ul>
    <li>A function that selects an event from the event set, Sε, </li>
    <li>A function that selects a plan, So ,</li>
    <li>A function that selects an intention to execute, SI .</li>
  </ul>
</ul>

It should be noted that in AgentSpeak(L) there is no definition of how these selection functions work.
