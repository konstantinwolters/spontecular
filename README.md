# SpOntecular ![Version](https://img.shields.io/badge/version-0.8.0-blue.svg?cacheSeconds=2592000)

> **Note: SpOntecular is currently in development.**
>
> SpOntecular is a proof of concept for (semi-) automating the extraction of an [ontology](https://en.wikipedia.org/wiki/Ontology_engineering) from technical specifications using the large language model GPT-4x and the semantic framework Apache Jena. The aim is to reduce the manual effort required to identify the individual ontology features.

## Development Status
SpOntecular is actively being developed. Below is an outline of its current and planned features.

## Supported features
### Implemented:
- Automated extraction of classes and based on that, deriving of taxonomic (hierarchical) and non-taxonomic relationships as well as cardinality constraints.
### In progress:
- Possibility to
    - provide custom definitions of the ontology features
    - add specific examples to provide more context for few-shot prompting
    - blacklist falsely identified features to exclude them from subsequent extraction cycles
### Planned:
- Functionality to import existing ontologies
- Functionality to download the resulting ontology

## Implementation schema

<img src="documentation/images/implementationschema.png" width="500" alt="Implementation Schema">

The extraction process was implemented as a seven-step workflow. The first four stages are used for the actual extraction of the individual ontology components using GPT-4. To do this, the text corpus from which the ontology is to be generated is first passed to GPT-4 via an API call, together with the appropriate prompt. JSON has been defined as the output format.

In step 1, the concepts are first identified and returned as a JSON list.  The results are then passed together with the text corpus to step 2 to build the concept hierarchy and to step 3 to identify the non-taxonomic relations. The identified non-taxonomic relations are then passed to stage 4 to derive the corresponding cardinalities. In addition to passing the intermediate results to each subsequent stage, they are also written to a cache. The cache is initially used to store the individual components of the ontology in order to merge them later.

## Functions / Technologies
| Function                                                     | Technology                                                                         |
|--------------------------------------------------------------|------------------------------------------------------------------------------------|
| <b>Front-End</b> <br> - Template Engine <br> - Interactivity | <br> Thymeleaf <br> Alpine.js, htmx                                                |
| <b>Backend</b>                                               | Spring Boot                                                                        |
| <b>Document processing</b>                                   | [Apache POI](https://poi.apache.org/), [Apache PDFBox](https://pdfbox.apache.org/) |
| <b>Ontology processing</b>                                   | [Apache Jena](https://jena.apache.org/)                                            |
| <b>Containerization</b>                                      | Docker                                                                             |

## Prerequisites
- Provide your OpenAI API key as environment variable ```OPENAI_API_KEY```.

## Access
- Enter ```http://localhost:8090``` after startup
- or visit live demo at [https://spontencular.konstantinwolters.com](https://spontecular.konstantinwolters.com/)
