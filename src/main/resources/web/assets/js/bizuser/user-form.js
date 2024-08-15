 

$(function () {
  RbForm.renderAfter = function (F) {
    if (F.state.entity !== 'User' || !F.isNew) return

    const newpwd = $random(null, true, 6) + 'rB!8'
    setFieldValue(F, 'password', newpwd)

    F.onFieldValueChange((o) => {
      if (o.name !== 'fullName' || !o.value) return

      $setTimeout(
        () => {
          $.get(`/user/checkout-name?fullName=${encodeURIComponent(o.value)}`, (res) => setFieldValue(F, 'loginName', res.data))
        },
        1000,
        'checkout-name'
      )
    })
  }
})

function setFieldValue(F, name, value) {
  const fieldComp = F.getFieldComp(name)
  if (fieldComp && value) fieldComp.setValue(value)
}
