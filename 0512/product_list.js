export default {
    template: `<div>
            <h3>목록입니다.</h3>
            <table border="1">
                <colgroup>
                    <col width="33%" />
                    <col width="33%" />
                    <col width="33%" />
                </colgroup>
                <tr>
                    <td>글번호</td>
                    <td>제목</td>
                    <td>작성자</td>
                </tr>
                <tr v-for="book in list.bList">
                    <td><a @click="sendBnum(book.bnum)" href="#">{{book.bnum}}</a></td>
                    <td>{{book.btitle}}</td>
                    <td>{{book.bwriter}}</td>
                </tr>
            </table>
            <input type="text" placeholder="페이지 입력" v-model="pageNum" v-on:keyup.enter="sendPage">
            <button @click="sendPage">검색</button>
        </div>
        `,
    data() {
        return {
            list: "",
            pageNum: "",
        };
    },
    created() {
        axios.get("http://127.0.0.1:9999/bootboard/boardMain").then((resp) => {
            console.log(JSON.stringify(resp.data));
            this.list = resp.data;
        });
        bus.$on("msg", this.msg);
    },
    // updated() {
    //     axios.get("http://127.0.0.1:9999/bootboard/boardMain").then((resp) => {
    //         console.log(JSON.stringify(resp.data));
    //         this.list = resp.data;
    //     });
    // },
    //이 방법 말고는 없나???? 이 방법 쓰면 페이지가 검색이 안됨, method로 따로 빼야하나?
    //여기에서 on , regist에서 emit?
    methods: {
        sendBnum(bnum) {
            console.log(bnum);
            bus.$emit("bnum", bnum);
        },
        sendPage() {
            axios
                .get("http://127.0.0.1:9999/bootboard/boardMain?page=" + this.pageNum)
                .then((resp) => {
                    console.log(JSON.stringify(resp.data));
                    this.list = resp.data;
                });
            this.pageNum = "";
        },
        msg(data) {
            alert("글작성에 성공했습니다.");
            axios.get("http://127.0.0.1:9999/bootboard/boardMain").then((resp) => {
                this.list = resp.data;
            });
        },
    },
};
