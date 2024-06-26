Input text:
"{inputText}"

Extract all ontology relationships from this technical specification that represent a strict subtype relationship where
one component is a more specialized version of another. This excludes "part-of" relationships where a component merely
forms part of another. For clarity, a "component" refers to any hardware part or software module listed in the
specification, and a "subtype relationship" implies a direct, more specific iteration of another component without
being merely a part of it.

Concentrate exclusively on the following classes: {classes}

Output your findings in JSON format, listing each identified relationship as [“parent class”, “subclass”] under the
'hierarchy’ field as a list.