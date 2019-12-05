import datetime
import threading
from queue import Queue

import requests

# 存放输出内容
final_domains = []
# 定义一个引用外部全局对象
gl = globals()
# 保存 http_ip 用于 whatweb
http_ip = []


# 线程的一种实现方式 (重写)
class PortScan(threading.Thread):
    def __init__(self, queue):
        threading.Thread.__init__(self)
        self._queue = queue

    def run(self):
        while not self._queue.empty():
            scan_ip = self._queue.get()
            try:
                short_url(scan_ip)
            except Exception as e:
                print(e)
                pass


# 启用多线程扫描
def main():
    qu = Queue()
    count = 10
    try:
        for i in range(count):
            qu.put("https://www.cnblogs.com/" + str(i))
        threads = []
        thread_count = 100
        for i in range(thread_count):
            threads.append(PortScan(qu))
        for t in threads:
            t.start()
        for t in threads:
            t.join()
    except Exception as e:
        print(e)
        pass


def short_url(url):
    data = {'urlValue': url, 'title': 'title'}
    baseurl = 'http://localhost:8088'
    print(url)
    requests.post(baseurl, json=data)


if __name__ == '__main__':
    start_time = datetime.datetime.now()
    count = 100
    main()
    spend_time = (datetime.datetime.now() - start_time).seconds
    print(str(count) + '条数据, 执行了 ' + str(spend_time) + ' 秒')
