```html
            <nav class="mt-5">
                <ul class="pagination justify-content-center">
                 
                    <li class="page-item"><a class="page-link" href="#"> 首页</a></li>
                    <li class="page-item disabled"><a class="page-link" href="#"> 上一页</a></li>
                    <li class="page-item active"><a class="page-link" href="#"> 1</a></li>
                    <li class="page-item "><a class="page-link" href="#"> 2</a></li>
                    <li class="page-item "><a class="page-link" href="#"> 3</a></li>
                    <li class="page-item "><a class="page-link" href="#"> 4</a></li>
                    <li class="page-item "><a class="page-link" href="#"> 5</a></li>
                    <li class="page-item "><a class="page-link" href="#"> 下一页</a></li>
                    <li class="page-item "><a class="page-link" href="#"> 末页</a></li>
                </ul>
            </nav>
```
```html

<li class="page-item">
    <a class="page-link" th:href="@{${page.path}(current=1)}">首页</a>
</li>
<li th:class="|page-item ${page.current==1?'disabled':''}|">
    <a class="page-link" th:href="@{${page.path}(current=${page.current-1})}">上一页</a></li>
<li th:class="|page-item ${i==page.current?'active':''}|"
    th:each="i:${#numbers.sequence(page.from,page.to)}">
    <a class="page-link" href="#" th:text="${i}">1</a>
</li>
<li th:class="|page-item ${page.current==page.total?'disabled':''}|">
    <a class="page-link" th:href="@{${page.path}(current=${page.current+1})}">下一页</a>
</li>
<li class="page-item">
    <a class="page-link" th:href="@{${page.path}(current=${page.total})}">末页</a>
</li>
```