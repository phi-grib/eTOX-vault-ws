Obtain the list of all models

http://phi.upf.edu/allmodels/?authkey=xxxxxxxxx (GET)
```json
[
{
"idmodel": "500",
"version": "2",
"verification_status": "Verified",
"modelid": "LQT10",
"partner": "FIMIM",
"modeltitle": "QT prolongation (at 10nM)",
"modeltag": "/Toxicity/Organ Toxicity/Cardiotoxicity/QT Prolongation/1"
}
]
```

Obtain model info by modelid


http://phi.upf.edu/modelinfo/92?authkey=xxxxxxxxx (GET)

```json
{
    externaltn: "0",
    relatedmodels: "CAV12; HERG4; KCNQ1",
    endpointmin: "0.0000",
    creationdate: "2016-02-08 00:00:00.0",
    externalother: "N/A",
    goftp: "0",
    externalq2: "0.0000",
    endpointdefinition: "Predicted QT after the drug administration at 10nM, expresed as % of normal QT (e.g. 110 value means that after the compound has been administered for obtaining a 100nM conc. the QT is expected to be 10% higher than the normal value)",
    testselection: "N/A",
    endpointmax: "0.0000",
    valuetype: "float",
    trainingsize: "0",
    externalfp: "0",
    modelid: "LQT10",
    dependentvariable: "Predicted QT expresed as % of the normal QT, for a drug concentration at the receptors site of 10nM",
    gofr2: "0.0000",
    gofrmse: "0.0000",
    descriptorsselection: "none",
    verification_status: "Verified",
    internalsdep: "0.0000",
    ADmethod: "ADAN, Carrio et al. DOI: 10.1021/ci500172z",
    idmodel: "500",
    ADassessment: "ADAN, Carrio et al. DOI: 10.1021/ci500172z",
    interpretation: "Predicted QT after the drug administration at 10nM, expresed as % of normal QT (e.g. 110 value means that after the compound has been administered for obtaining a 100nM conc. the QT is expected to be 10% higher than the normal value)",
    descriptorsdefinition: "N/A",
    contactemail: "manuel.pastor@upf.edu",
    mechanisticother: "N/A",
    partner: "FIMIM",
    contactname: "Manuel Pastor",
    goffn: "0",
    externalsdep: "0.0000",
    version: "2",
    references: "Obiol-Pardo C, Gomis-Tena J, Sanz F, Saiz J, Pastor M. A Multiscale Simulation System for the Prediction of Drug-Induced Cardiotoxicity. J Chem Inf Model 2011; 51(2): 483-92. PMID: 21250697",
    endpointavg: "0.0000",
    compoundidentifier: "N/A",
    externaldetails: "N/A",
    trainingcuration: "N/A",
    computationurl: "http://damocles.imim.es/etoxwsapi/v2/dir",
    externalfn: "0",
    units: "% (of normal QT in ms)",
    trainingtype: "N/A",
    compounddetails: "N/A",
    keywords: "QT prolongation, LQT",
    internalq2: "0.0000",
    supportinginfo: "N/A",
    mechanisticbasis: "N/A",
    valuerange: "(0,1000)",
    inferentialstats: "N/A",
    externaltp: "0",
    endpointpositivesperc: "0.00",
    endpointspecies: "N/A",
    modeltag: "/Toxicity/Organ Toxicity/Cardiotoxicity/QT Prolongation/1",
    modeltitle: "QT prolongation (at 10nM)",
    referencesother: "N/A",
    datasource: "This model was not built from a training series and is based on a electrophysiological representation of the ventricular tisue",
    testsize: "0",
    goffp: "0",
    goftn: "0",
    modelalgorithm: "The QT was obtained from a surface pseudo-electrocardiogram obtained using a 1D simularion of ventricular tissue. The AP of the individual cells was modeled using a modified version of Luo-Rudy dynamic AP model of guinea pig cardiac cell. The effect of th",
    modeltype: "multiscale model",
    endpointskewed: "N/A",
    software: 
            [
                    {
                        softwaredescription: "AdrianaCode",
                        license: "commercial"
                    },
                    {
                        softwaredescription: "Corina",
                        license: "commercial"
                    }
            ]
}
```

Obtain model info by tag

http://phi.upf.edu/modelinfo/?authkey=xxxxxxxxx&modeltag=/Toxicity/Organ%20Toxicity/Cardiotoxicity/QT%20Prolongation/1&provider=FIMIM (GET)

```json
{
    externaltn: "0",
    relatedmodels: "CAV12; HERG4; KCNQ1",
    endpointmin: "0.0000",
    creationdate: "2016-02-08 00:00:00.0",
    externalother: "N/A",
    goftp: "0",
    externalq2: "0.0000",
    endpointdefinition: "Predicted QT after the drug administration at 10nM, expresed as % of normal QT (e.g. 110 value means that after the compound has been administered for obtaining a 100nM conc. the QT is expected to be 10% higher than the normal value)",
    testselection: "N/A",
    endpointmax: "0.0000",
    valuetype: "float",
    trainingsize: "0",
    externalfp: "0",
    modelid: "LQT10",
    dependentvariable: "Predicted QT expresed as % of the normal QT, for a drug concentration at the receptors site of 10nM",
    gofr2: "0.0000",
    gofrmse: "0.0000",
    descriptorsselection: "none",
    verification_status: "Verified",
    internalsdep: "0.0000",
    ADmethod: "ADAN, Carrio et al. DOI: 10.1021/ci500172z",
    idmodel: "500",
    ADassessment: "ADAN, Carrio et al. DOI: 10.1021/ci500172z",
    interpretation: "Predicted QT after the drug administration at 10nM, expresed as % of normal QT (e.g. 110 value means that after the compound has been administered for obtaining a 100nM conc. the QT is expected to be 10% higher than the normal value)",
    descriptorsdefinition: "N/A",
    contactemail: "manuel.pastor@upf.edu",
    mechanisticother: "N/A",
    partner: "FIMIM",
    contactname: "Manuel Pastor",
    goffn: "0",
    externalsdep: "0.0000",
    version: "2",
    references: "Obiol-Pardo C, Gomis-Tena J, Sanz F, Saiz J, Pastor M. A Multiscale Simulation System for the Prediction of Drug-Induced Cardiotoxicity. J Chem Inf Model 2011; 51(2): 483-92. PMID: 21250697",
    endpointavg: "0.0000",
    compoundidentifier: "N/A",
    externaldetails: "N/A",
    trainingcuration: "N/A",
    computationurl: "http://damocles.imim.es/etoxwsapi/v2/dir",
    externalfn: "0",
    units: "% (of normal QT in ms)",
    trainingtype: "N/A",
    compounddetails: "N/A",
    keywords: "QT prolongation, LQT",
    internalq2: "0.0000",
    supportinginfo: "N/A",
    mechanisticbasis: "N/A",
    valuerange: "(0,1000)",
    inferentialstats: "N/A",
    externaltp: "0",
    endpointpositivesperc: "0.00",
    endpointspecies: "N/A",
    modeltag: "/Toxicity/Organ Toxicity/Cardiotoxicity/QT Prolongation/1",
    modeltitle: "QT prolongation (at 10nM)",
    referencesother: "N/A",
    datasource: "This model was not built from a training series and is based on a electrophysiological representation of the ventricular tisue",
    testsize: "0",
    goffp: "0",
    goftn: "0",
    modelalgorithm: "The QT was obtained from a surface pseudo-electrocardiogram obtained using a 1D simularion of ventricular tissue. The AP of the individual cells was modeled using a modified version of Luo-Rudy dynamic AP model of guinea pig cardiac cell. The effect of th",
    modeltype: "multiscale model",
    endpointskewed: "N/A",
    software: 
            [
                {
                    softwaredescription: "AdrianaCode",
                    license: "commercial"
                },
                {
                    softwaredescription: "Corina",
                    license: "commercial"
                }
            ]
}
```
