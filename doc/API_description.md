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


http://phi.upf.edu/modelinfo/5000?authkey=xxxxxxxxx (GET)

```json
{
    "modeltype": "multiscale model",
    "idmodel": "500",
    "goftn": "0",
    "goffn": "0",
    "compounddetails": "N/A",
    "version": "2",
    "trainingtype": "N/A",
    "datasource": "This model was not built from a training series and is based on a electrophysiological representation of the ventricular tisue",
    "endpointmax": "0.0000",
    "externaltn": "0",
    "units": "% (of normal QT in ms)",
    "dependentvariable": "Predicted QT expresed as % of the normal QT, for a drug concentration at the receptors site of 10nM",
    "externaltp": "0",
    "compoundidentifier": "N/A",
    "supportinginfo": "N/A",
    "internalq2": "0.0000",
    "goffp": "0",
    "descriptorsselection": "none",
    "goftp": "0",
    "relatedmodels": "CAV12; HERG4; KCNQ1",
    "externalq2": "0.0000",
    "verification_status": "Verified",
    "mechanisticbasis": "N/A",
    "gofr2": "0.0000",
    "modelid": "LQT10",
    "partner": "FIMIM",
    "externaldetails": "N/A",
    "inferentialstats": "N/A",
    "testsize": "0",
    "externalfn": "0",
    "ADmethod": "ADAN, Carrio et al. DOI: 10.1021/ci500172z",
    "modelalgorithm": "The QT was obtained from a surface pseudo-electrocardiogram obtained using a 1D simularion of ventricular tissue. The AP of the individual cells was modeled using a modified version of Luo-Rudy dynamic AP model of guinea pig cardiac cell. The effect of th",
    "internalsdep": "0.0000",
    "valuetype": "float",
    "externalsdep": "0.0000",
    "trainingcuration": "N/A",
    "referencesother": "N/A",
    "endpointspecies": "N/A",
    "contactemail": "manuel.pastor@upf.edu",
    "descriptorsdefinition": "N/A",
    "creationdate": "2016-02-08 00:00:00.0",
    "modeltitle": "QT prolongation (at 10nM)",
    "endpointdefinition": "Predicted QT after the drug administration at 10nM, expresed as % of normal QT (e.g. 110 value means that after the compound has been administered for obtaining a 100nM conc. the QT is expected to be 10% higher than the normal value)",
    "references": "Obiol-Pardo C, Gomis-Tena J, Sanz F, Saiz J, Pastor M. A Multiscale Simulation System for the Prediction of Drug-Induced Cardiotoxicity. J Chem Inf Model 2011; 51(2): 483-92. PMID: 21250697",
    "gofrmse": "0.0000",
    "externalfp": "0",
    "externalother": "N/A",
    "endpointavg": "0.0000",
    "valuerange": "(0,1000)",
    "computationurl": "http://damocles.imim.es/etoxwsapi/v2/dir",
    "keywords": "QT prolongation, LQT",
    "ADassessment": "ADAN, Carrio et al. DOI: 10.1021/ci500172z",
    "endpointmin": "0.0000",
    "endpointpositivesperc": "0.00",
    "mechanisticother": "N/A",
    "interpretation": "Predicted QT after the drug administration at 10nM, expresed as % of normal QT (e.g. 110 value means that after the compound has been administered for obtaining a 100nM conc. the QT is expected to be 10% higher than the normal value)",
    "trainingsize": "0",
    "contactname": "Manuel Pastor",
    "endpointskewed": "N/A",
    "modeltag": "/Toxicity/Organ Toxicity/Cardiotoxicity/QT Prolongation/1",
    "testselection": "N/A",
    software: [
                {
                "softwaredescription": "AdrianaCode",
                "license": "commercial"
                },
                {
                "softwaredescription": "Corina",
                "license": "commercial"
                }
            ]
            }
```
