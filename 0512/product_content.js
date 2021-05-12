// import cmtAdd from "./cmt_add.js";

export default {
    template: `
        <div>
            <table border="1">
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>내용</th>
                </tr>
                <tr>
                    <td>{{bookinfo.bnum}}</td>
                    <td>{{bookinfo.btitle}}</td>
                    <td>{{bookinfo.bwriter}}</td>
                    <td>{{bookinfo.bcontent}}</td>
                </tr>
            </table>
            댓글 목록
            <table border="1">
                <tr>
                    <th>댓글 작성자</th>
                    <th>댓글 내용</th>
                </tr>
                <tr v-for="cmt in cmtList">
                    <td>{{cmt.cwriter}}</td>
                    <td>{{cmt.ccontent}}</td>
                </tr>
            </table>
            댓글작성자 :<input type="text" v-model="cwriter"><br>
            댓글내용 :<input type="text" v-model="ccontent">
            <button @click="addCmt">댓글 등록</button>
        </div>
    `,
    data() {
        return {
            bnum: "",
            cwriter: "",
            ccontent: "",
            bookinfo: "",
            cmtList: "",
        };
    },
    created() {
        bus.$on("bnum", this.getBnum);
    },
    methods: {
        getBnum(bnum) {
            this.bnum = bnum;
            console.log("bnum은" + bnum);
            axios.get("http://127.0.0.1:9999/bootboard/board?bnum=" + bnum).then((resp) => {
                console.log(JSON.stringify(resp));
                this.bookinfo = resp.data;
                axios.get("http://127.0.0.1:9999/bootboard/ajax?bnum=" + bnum).then((resp) => {
                    console.log(JSON.stringify(resp));
                    this.cmtList = resp.data;
                    console.log(this.cmtList);
                });
            });
        },
        addCmt() {
            axios
                .post("http://127.0.0.1:9999/bootboard/ajax", {
                    bnum: this.bnum,
                    cwriter: this.cwriter,
                    ccontent: this.ccontent,
                })
                .then((resp) => {
                    console.log("resp" + resp);
                    console.log(resp);
                    if (resp.data == "success") {
                        alert("댓글작성에 성공하였습니다.");

                        axios
                            .get("http://127.0.0.1:9999/bootboard/ajax?bnum=" + this.bnum)
                            .then((resp) => {
                                console.log("여기에서는" + JSON.stringify(resp));
                                this.cmtList = resp.data;
                                console.log(this.cmtList);
                                this.cwriter = "";
                                this.ccontent = "";
                            });
                    }
                });
        },
    },
    // components: { cmtAdd },
};
