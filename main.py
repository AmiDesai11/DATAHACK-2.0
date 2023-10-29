import streamlit as st
import plotly.express as px
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import pyodbc
# Create a Streamlit app with a sidebar

# Create a sidebar with four buttons
selection = st.sidebar.radio("Select a page:", ( "Screener", "Trivia"))

if selection == "Screener":
    st.markdown("<h1 style='text-align: center;'>Sectoral Analysis</h1>", unsafe_allow_html=True)
    data_option = st.sidebar.radio("Select Sector", ["None", "AI", "EV"])
    data = {
    "None": None,
    "AI": "This is data for Option 1.",
    "EV": "This is data for Option 2.",
    }

    if data_option == "None":
      st.write("Sectoral analysis, also known as sector analysis, is a method of evaluating and understanding various sectors or industries within an economy. This analysis focuses on assessing the performance, trends, opportunities, challenges, and factors affecting specific sectors, such as technology, healthcare, finance, energy, or any other area of economic activity. Sectoral analysis is an essential tool for investors, policymakers, businesses, and financial professionals to make informed decisions and allocate resources effectively. Here are the key aspects and purposes of sectoral analysis:")

      st.write("1) Performance Assessment: Sectoral analysis begins with evaluating the historical and current performance of different sectors. This includes examining financial indicators, growth rates, market share, and other relevant metrics. By comparing the performance of various sectors, analysts can identify which areas of the economy are thriving and which ones may be struggling.")  
      st.write("2) Trend Identification: Identifying trends within specific sectors is a crucial part of sectoral analysis. This involves recognizing patterns related to market dynamics, consumer behavior, technological advancements, and regulatory changes. Understanding trends can help stakeholders anticipate future developments and make informed decisions.")  
      st.write("3) Opportunity Recognition: Sectoral analysis helps investors and businesses identify investment opportunities. For example, if a particular sector, like renewable energy, is experiencing rapid growth and positive trends, it may present attractive investment opportunities. Recognizing these prospects allows stakeholders to allocate resources effectively.")    
    elif data_option == "AI":
        df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_StartUp_Yearly_Projected_Growth.csv")
        df = df.set_index("Year")
        fig = px.line(df, x=df.index, y='Market Size in Rs.', title='Projected Growth')

        data = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_StartUp_By_State.csv")
        fig.update_xaxes(title='Year')
        fig.update_yaxes(title='Market Size')
        st.plotly_chart(fig, use_container_width=True)
        st.markdown(
    "<div style='border: 2px solid #e6e6e6; padding: 10px;'><h3 style='text-align: center;'>Growth Propellants</h3>"
    "<p>Generative AI offers operational benefits across customer operations, marketing, software engineering, and R&D. "
    "It enhances personalization, content creation, and efficiency, reducing time spent on various tasks.</p> <br>"
    "<h3 style='text-align: center;'>Hurdles</h3><p>Challenges include addressing biases in training data, ensuring human oversight, and managing workforce transformation.There are concerns about the impact on employment and potential risks in the transition to generative AI.</p></div>",
    unsafe_allow_html=True
)     
        data = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_StartUp_By_State.csv")
        fig = px.bar(data, x='State', y='Count', title='Count')
        st.plotly_chart(fig, use_container_width=True)

        d = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_StartUp_Yearly_Funding.csv")
        d = d.set_index("Year")
        fig = px.line(d, x=d.index, y='Total Funding in Rs.', title='Total Funding')
        fig.update_xaxes(title='Year')
        fig.update_yaxes(title='Total Funding')
        st.plotly_chart(fig, use_container_width=True)
        st.markdown(
    "<div style='border: 2px solid #e6e6e6; padding: 10px;'><h3 style='text-align: center;'>Future Prospects of the Industry</h3>"
    "<p>Generative AI holds potential to add trillions to the global economy, transforming industries and automating tasks."
    "It promises to revolutionize work, boost productivity, and contribute to economic growth.</p></div>",
    unsafe_allow_html=True
)
        st.markdown("<h1 style='text-align: center;'>StartUp Analysis</h1>", unsafe_allow_html=True)
        #data = st.selectbox.radio('Select a metric', ['Funding', 'No. Of Investors', 'Visibility'])
        data_opt = st.selectbox("Select Sector", ['Funding', 'No. Of Investors', 'Visibility'])
        data = {
         "Funding": None,
         "No. Of Investors": "This is data for Option 1.",
         "Visibility": "This is data for Option 2.",
        }
        if data_opt == "Funding":
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_Funding.csv")
            st.dataframe(df)
        elif data_opt == "No. Of Investors":
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_Investors.csv")
            st.dataframe(df)
        elif data_opt == "Visibility":
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_VISIBILITY.csv")
            st.dataframe(df)
        st.write("Average Funds Growth: Represents the delta in a startup's funding. A higher delta  would result in a better valuation for the startup."
"Viability Quotient: Represents the ratio of the total funding rounds taken by the startup to the age of the startup."
"Investment Intensity Index: Represents the ratio of the total funding of the startup to the total investors of that startup."
"Investor Confidence Index: Represents the percentage of lead investors among the total investors in a startup."
"Monthly Engagement Rate:  Represents the monthly growth rate of user visits, for a startup's platform. "
"Total Monthly Downloads:  Represents the total monthly downloads of a startup's platform.")
    elif data_option == "EV":
        st.write("Data Visualization for Option 2:")
        df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\EV_StartUp_Yearly_Projected_Growth.csv")
        df = df.set_index("Year")
        fig = px.line(df, x=df.index, y='Sales', title='Projected Growth')
        data = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\AI_StartUp_By_State.csv")
        fig.update_xaxes(title='Year')
        fig.update_yaxes(title='Sales')
        st.plotly_chart(fig, use_container_width=True)
        st.markdown("<div style='border: 2px solid #e6e6e6; padding: 10px;'><h3 style='text-align: center;'>Growth Propellants</h3>"
    "<p>Growing consumer interest in sustainability and environmental benefits.Lower total cost of ownership and reduced engine noise."
"Need for accessible and reliable charging infrastructure.</p> <br>"
    "<h3 style='text-align: center;'>Hurdles</h3><p>Safety and Battery Life Concerns: Addressing safety issues and ensuring durable battery life to build consumer trust."

"Charging Infrastructure Readiness: Availability of charging infrastructure in regions where two-wheelers are prevalent is a challenge."

"Consumer Education and Trust: Educating consumers, fostering trust, and ensuring a supportive ecosystem for adoption.</p></div>",
    unsafe_allow_html=True)

        data = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\EV_StartUp_Yearly_Funding.csv")
        data = data.set_index("Year")
        fig = px.line(data, x=data.index, y='Total Fundingin Rs.', title='Total Funding')
        fig.update_xaxes(title='Year')
        fig.update_yaxes(title='Total Funding')
        st.plotly_chart(fig, use_container_width=True)

        
        #d = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\EV_StartUp_Yearly_Projected_Penetration.csv")
        #d = d.set_index("Year")
        #fig = px.line(d, x=d.index, y=d.columns[1:], title=f"Funding Over the Years by Company")
        #fig.update_layout(xaxis_title="Year", yaxis_title="Automotives")
        #st.plotly_chart(fig, use_container_width=True)
        st.markdown("<h1 style='text-align: center;'>StartUp Analysis</h1>", unsafe_allow_html=True)
        #data = st.selectbox.radio('Select a metric', ['Funding', 'No. Of Investors', 'Visibility'])
        data_opt = st.selectbox("Select Sector", ['Funding', 'No. Of Investors', 'Visibility'])
        data = {
         "Funding": None,
         "No. Of Investors": "This is data for Option 1.",
         "Visibility": "This is data for Option 2.",
        }
        if data_opt == "Funding":
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\Final_By_Funding.csv")
            st.dataframe(df)
        elif data_opt == "No. Of Investors":
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\Final_By_Investors.csv")
            st.dataframe(df)
        elif data_opt == "Visibility":
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\Final_By_Visibility.csv")
            st.dataframe(df)




# Define the data for each option

elif selection == "Trivia":
    # App title
    #st.header("Welcome to the Home Page")
    st.title('StartUp Ecosystem Trivia')
    
    # App description
    #st.write('Here are 10 questions with interactive data visualizations:')
    
    def Visual(num):
        if num == 3:
            st.subheader('Comparison between Foreign and Domestic Funds and the sectors they are investing in.')
            df = pd.read_excel("C:\\Users\\dhava\\Desktop\\Streamlit\\FundingData.xlsx")
            df['Domestic Capital'] = pd.to_numeric(df['Domestic Capital'], errors='coerce')
            df['International Capital'] = pd.to_numeric(df['International Capital'], errors='coerce')

# Create a bar chart
            fig = px.bar(df, x='Date', y=['Domestic Capital', 'International Capital'], title='Domestic vs International Capital Over the Years', color='Sector',
                        labels={'Domestic Capital': 'Domestic Capital', 'International Capital': 'International Capital'})

# Add a filter for sectors
            selected_sector = st.selectbox("Select a Sector:", ['All'] + df['Sector'].unique().tolist())

# Filter the data based on the selected sector
            if selected_sector != 'All':
                filtered_df = df[df['Sector'] == selected_sector]
                fig = px.bar(filtered_df, x='Date', y=['Domestic Capital', 'International Capital'], title=f'{selected_sector} Capital Over the Years',
                 labels={'Domestic Capital': 'Domestic Capital', 'International Capital': 'International Capital'})

# Update the layout and show the chart
            fig.update_layout(barmode='stack')
            fig.update_xaxes(categoryorder='total ascending')
            fig.update_yaxes(title_text='Capital')
            st.plotly_chart(fig, use_container_width=True)
        elif num == 2:
            st.subheader('Location-wise distribution of the top 100 startups.')
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\Indian Unicorn startups 2023 updated.csv")
            city_counts = df["Location"].value_counts().reset_index()
            city_counts.columns = ["City", "Frequency"]
    
            fig = px.bar(city_counts, x="City", y="Frequency", title="Frequency of Cities")
            fig.update_xaxes(categoryorder="total descending")
            st.plotly_chart(fig, use_container_width=True)
        elif num == 6:
            st.subheader('Startups in which sectors have been stagnating or decreasing.')
            df = pd.read_excel("C:\\Users\\dhava\\Desktop\\Streamlit\\FundingData.xlsx")
            #df = df.sort_values(by='Total Capital')

# Create a bar chart using Plotly Express
            grouped_data = df.groupby('Sector', as_index=False)['Total Capital'].sum()

# Create a bar chart using Plotly Express
            fig = px.bar(grouped_data, x='Sector', y='Total Capital', title='Total Capital by Sector', color = "Sector")

# Display the chart in Streamlit
            st.plotly_chart(fig, use_container_width=True)

        elif num == 4:
            st.subheader('Valuation based analysis on Fintech companies over the last 5 years.')
            #df = pd.read_excel("C:\\Users\\dhava\\Desktop\\Streamlit\\Fintech_StartUps.xlsx")
            xls = pd.ExcelFile("C:\\Users\\dhava\\Desktop\\Streamlit\\Fintech_StartUps.xlsx")

# List sheet names
            sheet_names = xls.sheet_names

# Let the user select a sheet
            selected_sheet = st.selectbox("Select a sheet:", sheet_names)

# Check if a sheet is selected
            if selected_sheet:
    # Load the selected sheet into a DataFrame
                df = pd.read_excel(xls, sheet_name=selected_sheet)
                fig = px.line(df, x='Year', y=df.columns[1:], title=f"Funding Over the Years by Company - {selected_sheet}")
                fig.update_layout(xaxis_title="Year", yaxis_title="Funding")
                st.plotly_chart(fig, use_container_width=True)
        elif num == 5:
            st.subheader('Affect of covid on funding for startups across different sectors.')
            data = pd.read_excel("C:\\Users\\dhava\\Desktop\\Streamlit\\FundingData.xlsx")
            data['Date'] = pd.to_datetime(data['Date'])
            
# Create a line chart using Plotly
            fig = px.line(data, x='Date', y='Total Capital', color='Sector', title='Total Capital Over Time by Sector')

            st.plotly_chart(fig, use_container_width=True)
        elif num == 1:
            st.subheader('Sectors having most number of new and emerging startups')
            df = pd.read_csv("C:\\Users\\dhava\\Desktop\\Streamlit\\indian_startups_by_state.csv")
            value_counts = df['Industry'].value_counts().reset_index()
            value_counts.columns = ['Industry', 'Count']
            fig = px.bar(value_counts, x='Industry', y='Count', title='Count of Feature', color= "Industry")
            st.plotly_chart(fig, use_container_width=True)  

# Add a red line marking the minimum value

# Display the chart in Streamlit
    
    row1 = st.columns(2)
    col_spacing = 2

    for i in range(2):
        with row1[i]:
            Visual(i+1)
            if i < col_spacing - 1:
                st.empty()

    row2 = st.columns(2)

    for i in range(2):
        with row2[i]:
            Visual(i+3)
            if i < col_spacing - 1:
                st.empty()
            
    row3 = st.columns(2)

    for i in range(2):
        with row3[i]:
            Visual(i+5)
            if i < col_spacing - 1:
                st.empty()
