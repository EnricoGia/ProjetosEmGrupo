import plotly.graph_objects as go
from plotly.subplots import make_subplots
import plotly.express as px

df = df[df['Data']>0]
df['Timestamp'] = pd.to_datetime(df['Timestamp'])
df = df[(df['Id'] ==1)|(df['Id'] ==6)]

dfp = pd.pivot_table(df,
                     values='Data',
                     index=['Timestamp'],
                     columns=['Id'],
               )
nrows = len(dfp.columns) 
fig = make_subplots(rows=nrows,
                    cols=1,
                    subplot_titles=['Id '+str(c) for c in dfp.columns])

# add traces


fig.update_layout(height=nrows*500)
fig.show()
#teste de alterando o codigo
print(1234+ "segredo")

####################################===