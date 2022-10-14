from cgi import test
import requests
from bs4 import BeautifulSoup

url = '<조회 할 블로그 링>'

def getImage(url, idx) :
    headers = {"User-Agent":""}
    response = requests.get(url, headers=headers)
    with open("<저장위치>/img_{}.jpg".format(idx+1), "wb") as f:
        f.write(response.content)

def getIframe(url) :
    headers = {"User-Agent":""}
    response = requests.get(url, headers=headers)
    soup = BeautifulSoup(response.text, "lxml")
    text = soup.find("iframe")
    return text['src']

def getSubHtml(url) :
    headers = {"User-Agent":""}
    response = requests.get(url, headers=headers)
    soup = BeautifulSoup(response.text, "lxml")
    if soup.find("div", attrs={"class":"se-main-container"}):
        text = soup.find("div", attrs={"class":"se-main-container"}).get_text()
        text = text.replace("\n","") #공백 제거
        images = soup.find_all("img")
        for idx, image in enumerate(images):
            if image.get("src") and image.get("class") :
                if 'postfiles' in image["src"]:
                    print(image["src"][:-5]+'0')
                    getImage((image["src"][:-5]+'0'), idx)
                  
        return text
    else:
        return "확인불가"


src_url = getIframe(url)
result = getSubHtml('https://blog.naver.com'+src_url)
print(result)
