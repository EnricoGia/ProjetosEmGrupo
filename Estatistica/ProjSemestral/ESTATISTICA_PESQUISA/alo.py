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
x = 1
for i, col in enumerate(dfp.columns):
    fig.add_trace(go.Scatter(x=dfp.index, y=dfp[col].values,
                             name = 'Id '+str(col),
                             mode = 'lines',
                             ),
                  row=i+1,
                  col=1)

fig.update_layout(height=nrows*500)
fig.show()