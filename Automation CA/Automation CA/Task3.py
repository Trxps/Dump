import requests
from bs4 import BeautifulSoup
import pandas as pd

pagesAmount = int(input('>Enter the number of pages you want to scrape: '))


def extract(page):
    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 OPR/93.0.0.0' }
    url = f'https://ie.indeed.com/jobs?q=java%20developer&l=donegal&start={page}'
    r = requests.get(url, headers = headers)
    soup = BeautifulSoup(r.content, 'html.parser')
    return soup

def transform(soup):
    divs = soup.find_all('div', class_ = 'slider_container css-11g4k3a eu4oa1w0')
    for item in divs:
        title = item.find('a').text
        company = item.find('span', class_ = 'companyName').text
        try: 
            salary = item.find('span', class_ = 'metadata salary-snippet-container').text
        except:
            salary = ''
            date = item.find('li', class_ = 'updated-time').text
        description = item.find('p').find('span').text.replace('\n', '')


        job = {
            'title': title,
            'company': company,
            'salary': salary,
            'Description': description }
        
        joblist.extend(job)
    return  

joblist = []

for i in range(1, (pagesAmount + 1)):
        print(f'Getting page, {i}')
        c = extract(0)
        transform(c)

df = pd.DataFrame(joblist)
print(df.head())

df.to_csv('Task2.csv')
print(f'finished! please check your task2 file for the results')


    
