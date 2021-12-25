

const user = {
    login: (info) => {
        let account = info.id.value;
        let pw = info.password.value;

        console.log(pw);

        let data = JSON.stringify({data: {
            account,
            password: pw
        }})

        axios.post(this.action, data,
        {
            headers: { "Content-Type": `application/json`},
        }).then((response) => {
            console.log(response);
        });
    }
}