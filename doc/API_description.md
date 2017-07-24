Description | Obtain the list of all models| Obtain info for a model by modelid | Obtain info for a model by modeltag
------------ | -------------| ------ | --------
Method | /allmodels | /modelinfo |  /modelinfo |
Parameters |  authkey (security key) | authkey (security key) <br> modelid (in URL) | authkey (security key) <br> modeltag <br> provider (partner)
URL example |  http://phi.upf.edu/allmodels/?authkey=xxxxxxxxx | http://phi.upf.edu/modelinfo/5000?authkey=xxxxxxxxx | http://phi.upf.edu/modelinfo/?authkey=xxxxxxxxx&modeltag=/Toxicity/Organ%20Toxicity/Cardiotoxicity/QT%20Prolongation/1&provider=FIMIM
Example respondes | [allmodels](allmodels.md) | [modelbyid](modelbyid.md) | [modelbytab](modelbytag.md)
